package za.co.tt.service;


import za.co.tt.domain.Order;
import za.co.tt.domain.User;
import za.co.tt.domain.OrderItem;
import za.co.tt.domain.Product;
import za.co.tt.repository.OrderRepository;
import za.co.tt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final IProductService productService;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository, IProductService productService) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productService = productService;
    }

    /**
     * Debug method to test basic JPA functionality
     */
    public List<Order> getAllOrdersBasic() {
        logger.info("Fetching all orders using basic findAll()");
        List<Order> orders = orderRepository.findAll();
        logger.info("Found {} orders using basic findAll()", orders.size());
        return orders;
    }

    @Override
    public List<Order> getAllOrders() {
        logger.info("Fetching all orders from database");
        List<Order> orders = orderRepository.findAllWithItems();
        logger.info("Found {} orders in database", orders.size());
        return orders;
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        logger.info("Fetching order with ID: {}", id);
        Optional<Order> order = orderRepository.findByIdWithItems(id);
        logger.info("Order found: {}", order.isPresent());
        return order;
    }

    @Override
    @Transactional
    public Order createOrder(za.co.tt.domain.OrderDto orderDto) {
        logger.info("Creating order for userId: {}", orderDto.getUserId());
        // Allowed statuses
        String[] allowedStatuses = {"pending", "processing", "shipped", "delivered"};
        String status = orderDto.getStatus();
        boolean validStatus = false;
        for (String s : allowedStatuses) {
            if (s.equalsIgnoreCase(status)) {
                validStatus = true;
                status = s; // normalize
                break;
            }
        }
        if (!validStatus) {
            status = "pending";
        }

    // Validate userId
    if (orderDto.getUserId() == null) {
        throw new IllegalArgumentException("UserId must not be null");
    }
    // Fetch managed User entity
    User managedUser = userRepository.findById(orderDto.getUserId())
        .orElseThrow(() -> new RuntimeException("User not found for id: " + orderDto.getUserId()));

        // Validate order items
        List<OrderItem> items = orderDto.getOrderItems();
        logger.debug("Validating {} order items", items != null ? items.size() : 0);
        
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }
        
        // Validate each order item and check stock availability
        for (int i = 0; i < items.size(); i++) {
            OrderItem item = items.get(i);
            if (item == null) {
                throw new IllegalArgumentException("OrderItem at index " + i + " is null");
            }
            if (item.getProductId() == null) {
                throw new IllegalArgumentException("OrderItem at index " + i + " is missing productId. Please ensure each item has a valid productId.");
            }
            if (item.getQuantity() <= 0) {
                throw new IllegalArgumentException("OrderItem at index " + i + " must have a positive quantity");
            }
            if (item.getPrice() == null || item.getPrice().compareTo(java.math.BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("OrderItem at index " + i + " must have a valid positive price");
            }
            
            // Check if product exists and has sufficient stock
            Product product = productService.getProductById(item.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product with ID " + item.getProductId() + " not found"));
            
            if (product.getStockQuantity() < item.getQuantity()) {
                throw new IllegalArgumentException("Insufficient stock for product '" + product.getProductName() + "'. " +
                    "Available: " + product.getStockQuantity() + ", Requested: " + item.getQuantity());
            }
            
            logger.debug("Stock check passed for product {}: available={}, requested={}", 
                product.getProductName(), product.getStockQuantity(), item.getQuantity());
        }

        Order order = new Order();
        order.setUser(managedUser);
        order.setOrderStatus(status);
        order.setOrderDate(java.time.LocalDateTime.now());
        
        // Set the order reference on each item
        for (OrderItem item : items) {
            item.setOrder(order);
        }
        order.setOrderItems(items);
        Double totalPrice = orderDto.getTotalPrice();
        if (totalPrice == null) {
            totalPrice = 0.0;
        }
        order.setTotalAmount(totalPrice);

        // Set order reference on items
        if (order.getOrderItems() != null) {
            for (OrderItem item : order.getOrderItems()) {
                item.setOrder(order);
            }
        }

        // Save the order first to get the ID
        Order savedOrder = orderRepository.save(order);
        
        // Reduce stock quantities for each ordered item
        for (OrderItem item : savedOrder.getOrderItems()) {
            Product product = productService.getProductById(item.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found during stock reduction: " + item.getProductId()));
            
            int newStockQuantity = product.getStockQuantity() - item.getQuantity();
            productService.updateStockQuantity(product.getProductId(), newStockQuantity);
            
            logger.info("Reduced stock for product {}: {} -> {} (ordered: {})", 
                product.getProductName(), product.getStockQuantity(), newStockQuantity, item.getQuantity());
        }
        
        return savedOrder;
    }

    @Override
    @Transactional
    public Order updateOrder(Long id, Order updatedOrder) {
        Order existingOrder = orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        
        // If the order status is being changed to "cancelled", restore stock
        if ("cancelled".equalsIgnoreCase(updatedOrder.getOrderStatus()) && 
            !"cancelled".equalsIgnoreCase(existingOrder.getOrderStatus())) {
            restoreStockQuantities(existingOrder);
            logger.info("Order {} cancelled, stock quantities restored", id);
        }
        
        // Update the order fields (excluding items for now to keep it simple)
        existingOrder.setOrderStatus(updatedOrder.getOrderStatus());
        existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
        
        return orderRepository.save(existingOrder);
    }

    @Override
    @Transactional
    public void deleteOrder(Long id) {
        // Get the order to restore stock quantities
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        
        // Restore stock quantities before deleting the order
        restoreStockQuantities(order);
        
        orderRepository.deleteById(id);
        logger.info("Deleted order {} and restored stock quantities", id);
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        logger.info("Fetching orders for user ID: {}", userId);
        List<Order> orders = orderRepository.findByUser_UserId(userId);
        logger.info("Found {} orders for user {}", orders.size(), userId);
        return orders;
    }

    @Override
    public List<Order> getOrdersByStatus(String status) {
        logger.info("Fetching orders with status: {}", status);
        List<Order> orders = orderRepository.findByOrderStatus(status);
        logger.info("Found {} orders with status {}", orders.size(), status);
        return orders;
    }

    @Override
    public Order save(Order entity) {
        return null;
    }

    @Override
    public Order update(Order entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (!orderRepository.existsById(id)) {
            throw new IllegalArgumentException("Entity with ID " + id + " not found");
        }
        orderRepository.deleteById(id);
    } //made some changes to avoid error


    @Override
    public Order read(Long aLong) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return List.of();
    }

    /**
     * Restores stock quantities when an order is cancelled or deleted
     * @param order The order whose stock quantities should be restored
     */
    private void restoreStockQuantities(Order order) {
        if (order.getOrderItems() == null || order.getOrderItems().isEmpty()) {
            return;
        }
        
        for (OrderItem item : order.getOrderItems()) {
            Product product = productService.getProductById(item.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found during stock restoration: " + item.getProductId()));
            
            int restoredStockQuantity = product.getStockQuantity() + item.getQuantity();
            productService.updateStockQuantity(product.getProductId(), restoredStockQuantity);
            
            logger.info("Restored stock for product {}: {} -> {} (restored: {})", 
                product.getProductName(), product.getStockQuantity(), restoredStockQuantity, item.getQuantity());
        }
    }

    /**
     * Checks if an order can be fulfilled based on current stock levels (private helper)
     * @param orderItems The list of items to check
     * @return true if all items can be fulfilled, false otherwise
     */
    private boolean canFulfillOrder(List<OrderItem> orderItems) {
        if (orderItems == null || orderItems.isEmpty()) {
            return false;
        }
        
        for (OrderItem item : orderItems) {
            Product product = productService.getProductById(item.getProductId())
                .orElse(null);
            
            if (product == null || product.getStockQuantity() < item.getQuantity()) {
                return false;
            }
        }
        return true;
    }
}
package za.co.tt.service;

import org.springframework.http.ResponseEntity;
import za.co.tt.domain.Cart;
import za.co.tt.domain.Order;
import za.co.tt.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found with id: " + id);
        }
        order.setOrderId(id);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found with id: " + id);
        }
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUser_UserId(userId);
    }

    @Override
    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByOrderStatus(status);
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
}
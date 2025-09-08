package za.co.tt.Serice;

import za.co.tt.domain.Admin;
import za.co.tt.domain.Product;
import za.co.tt.domain.OrderItem;
import za.co.tt.repository.ProductRepository;
import za.co.tt.repository.OrderItemRepository;
import java.util.List;

public class AdminService {
    private ProductRepository productRepository;
    private OrderItemRepository orderItemRepository;

    public AdminService(ProductRepository productRepository, OrderItemRepository orderItemRepository) {
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public List<Product> viewAllProducts() {
        return productRepository.getAllProducts();
    }

    public List<OrderItem> viewAllOrderItems() {
        return orderItemRepository.getAllOrderItems();
    }
}

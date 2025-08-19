// src/main/java/za/co/tt/service/impl/OrderItemService.java
package za.co.tt.service.impl;

import org.springframework.stereotype.Service;
import za.co.tt.domain.OrderItem;
import za.co.tt.repository.OrderItemRepository;
import za.co.tt.service.IOrderItemService;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements IOrderItemService {

    private final OrderItemRepository repository;

    public OrderItemServiceImpl(OrderItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderItem save(OrderItem item) {
        return repository.save(item);
    }

    @Override
    public List<OrderItem> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<OrderItem> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public OrderItem update(String id, OrderItem src) {
        OrderItem dst = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found: " + id));

        // update mutable fields
        dst.setCategory(src.getCategory());
        dst.setProductName(src.getProductName());
        dst.setQuantity(src.getQuantity());
        dst.setPrice(src.getPrice());

        return repository.save(dst);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}

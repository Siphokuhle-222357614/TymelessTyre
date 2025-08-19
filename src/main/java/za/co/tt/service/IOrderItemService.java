// src/main/java/za/co/tt/service/IOrderItemService.java
package za.co.tt.service;

import za.co.tt.domain.OrderItem;

import java.util.List;
import java.util.Optional;

public interface IOrderItemService {
    OrderItem save(OrderItem item);
    List<OrderItem> findAll();
    Optional<OrderItem> findById(String id);
    OrderItem update(String id, OrderItem item);
    void deleteById(String id);
}

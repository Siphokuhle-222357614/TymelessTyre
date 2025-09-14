package za.co.tt.service;

import za.co.tt.domain.OrderItem;
import java.util.List;
import java.util.Optional;

public interface IOrderItemService {

    OrderItem createOrderItem(OrderItem orderItem);

    Optional<OrderItem> getOrderItemById(Long id);

    List<OrderItem> getAllOrderItems();

    OrderItem updateOrderItem(OrderItem orderItem);

    void deleteOrderItem(Long id);
}
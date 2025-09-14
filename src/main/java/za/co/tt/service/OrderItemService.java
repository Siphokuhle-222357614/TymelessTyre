package za.co.tt.service;

import za.co.tt.domain.OrderItem;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class OrderItemService implements IOrderItemService {

    private final Map<Long, OrderItem> store = new HashMap<>();

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        store.put(orderItem.getProductId(), orderItem);
        return orderItem;
    }

    @Override
    public Optional<OrderItem> getOrderItemById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return new ArrayList<>(store.values());
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        store.put(orderItem.getProductId(), orderItem);
        return orderItem;
    }

    @Override
    public void deleteOrderItem(Long id) {
        store.remove(id);
    }
}
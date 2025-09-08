package za.co.tt.repository;

import za.co.tt.domain.OrderItem;
import java.util.ArrayList;
import java.util.List;

public class OrderItemRepository {
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItem item) {
        orderItems.add(item);
    }

    public List<OrderItem> getAllOrderItems() {
        return new ArrayList<>(orderItems);
    }

    public OrderItem getOrderItemById(String id) {
        for (OrderItem item : orderItems) {
            if (item.getOrderItemId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public void removeOrderItem(String id) {
        orderItems.removeIf(item -> item.getOrderItemId().equals(id));
    }
}

package za.co.tt.factory;

import za.co.tt.domain.OrderItem;
import java.math.BigDecimal;

public class OrderItemFactory {

    public static OrderItem createOrderItem(Long productId, int quantity, BigDecimal price) {
        return new OrderItem(productId, quantity, price);
    }

    public static OrderItem updateOrderItem(Long productId, int quantity, BigDecimal price) {
        return new OrderItem(productId, quantity, price);
    }

    public static OrderItem deleteOrderItem(Long productId) {
        // For delete, you may only need the productId
        return new OrderItem(productId, 0, BigDecimal.ZERO);
    }
}
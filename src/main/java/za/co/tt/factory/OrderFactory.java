package za.co.tt.factory;

import za.co.tt.domain.Order;
import za.co.tt.domain.User;
import za.co.tt.domain.OrderItem;
import java.time.LocalDateTime;
import java.util.List;

public class OrderFactory {

    public static Order createOrder(String orderId, User user, List<OrderItem> orderItems, LocalDateTime orderDate, String orderStatus, double totalAmount) {
        return new Order.Builder()
                .setOrderId(orderId)
                .setUser(user)
                .setOrderItems(orderItems)
                .setOrderDate(orderDate)
                .setOrderStatus(orderStatus)
                .setTotalAmount(totalAmount)
                .build();
    }

    public static Order updateOrder(String orderId, User user, List<OrderItem> orderItems, LocalDateTime orderDate, String orderStatus, double totalAmount) {
        return new Order.Builder()
                .setOrderId(orderId)
                .setUser(user)
                .setOrderItems(orderItems)
                .setOrderDate(orderDate)
                .setOrderStatus(orderStatus)
                .setTotalAmount(totalAmount)
                .build();
    }

    public static Order deleteOrder(String orderId) {
        return new Order.Builder()
                .setOrderId(orderId)
                .build();
    }
}
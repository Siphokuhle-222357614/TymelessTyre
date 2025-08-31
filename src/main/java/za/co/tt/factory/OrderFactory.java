package za.co.tt.factory;

import za.co.tt.domain.Address;
import za.co.tt.domain.Order;
import za.co.tt.domain.OrderItem;
import za.co.tt.domain.User;

//import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderFactory {

    public static Order createOrder(Long orderId, User user, List<OrderItem> orderItems,
                                    LocalDate orderDate, Address shippingAddress,
                                    String status, BigDecimal totalAmount, String paymentMethod) {
        // Validate fields
        if (orderId != null && orderId <= 0) {
            throw new IllegalArgumentException("OrderID must be a positive number");
        }
        return new Order.Builder()
                .setOrderId(orderId)
                .setUser(user)
                .setOrderItems(OrderItem)
                .setOrderDate(orderDate)
                .setShippingAddress(shippingAddress)
                .setStatus(status)
                .setTotalAmount(totalAmount)
                .setPaymentMethod(paymentMethod)
                .build();

    }
}

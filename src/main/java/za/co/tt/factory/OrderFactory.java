package za.co.tt.factory;

import za.co.tt.domain.Order;
import za.co.tt.domain.User;
import za.co.tt.domain.Address;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderFactory {
    public static Order createOrder(User user, LocalDate orderDate, Address shippingAddress,
                                    String status, BigDecimal totalAmount, String paymentMethod) {
        return new Order.Builder()
                .user(user)
                .orderDate(orderDate)
                .shippingAddress(shippingAddress)
                .status(status)
                .totalAmount(totalAmount)
                .paymentMethod(paymentMethod)
                .build();
    }
}
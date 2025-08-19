package za.co.tt.factory;

import za.co.tt.domain.OrderItem;

public class OrderItemFactory {

    // Simple method:

    public static OrderItem createOrderItem(String id, String productName, int quantity, double price) {
        return new OrderItem(id, productName, quantity, price);
    }
}

// src/main/java/za/co/tt/factory/OrderItemFactory.java
package za.co.tt.factory;

import za.co.tt.domain.OrderItem;

import java.util.UUID;

public class OrderItemFactory {

    // Simplest (lecturer-friendly): caller supplies the id
    public static OrderItem create(String id, String category, String productName, int quantity, double price) {
        return new OrderItem(id, category, productName, quantity, price);
    }

    // Convenience: auto-generate id with UUID
    public static OrderItem create(String category, String productName, int quantity, double price) {
        String id = UUID.randomUUID().toString();
        return new OrderItem(id, category, productName, quantity, price);
    }
}

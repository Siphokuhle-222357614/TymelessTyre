package za.co.tt.controllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.tt.controller.OrderItemController;
import za.co.tt.domain.OrderItem;
import za.co.tt.factory.OrderItemFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderItemControllerTest {

    private OrderItemController controller;

    @BeforeEach
    void setUp() {
        controller = new OrderItemController();
    }

    @Test
    void testCreateOrderItem() {
        OrderItem item = OrderItemFactory.create("Tyres", "Goodyear Eagle", 2, 1500.00);
        OrderItem created = controller.create(item);

        assertNotNull(created);
        assertEquals(item.getProductName(), created.getProductName());
    }

    @Test
    void testReadOrderItem() {
        OrderItem item = OrderItemFactory.create("Batteries", "Exide Premium", 1, 1200.00);
        controller.create(item);

        OrderItem readItem = controller.read(item.getId());
        assertNotNull(readItem);
        assertEquals("Exide Premium", readItem.getProductName());
    }

    @Test
    void testGetAllOrderItems() {
        controller.create(OrderItemFactory.create("Tyres", "Michelin Energy", 4, 2000.00));
        controller.create(OrderItemFactory.create("Tyres", "Bridgestone DriveGuard", 2, 1800.00));

        List<OrderItem> allItems = controller.getAll();
        assertFalse(allItems.isEmpty());
        assertTrue(allItems.size() >= 2);
    }

    @Test
    void testDeleteOrderItem() {
        OrderItem item = OrderItemFactory.create("Oil", "Castrol Edge", 1, 600.00);
        controller.create(item);

        boolean deleted = controller.delete(item.getId());
        assertTrue(deleted);

        // Verify it's deleted
        OrderItem readItem = controller.read(item.getId());
        assertNull(readItem);
    }
}

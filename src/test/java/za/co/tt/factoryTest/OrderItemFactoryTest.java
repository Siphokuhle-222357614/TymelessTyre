package za.co.tt.factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.OrderItem;
import za.co.tt.factory.OrderItemFactory;

import static org.junit.jupiter.api.Assertions.*;

public class OrderItemFactoryTest {

    @Test
    void testCreateWithId() {
        OrderItem item = OrderItemFactory.create("item101", "Tyres", "Goodyear Eagle", 2, 1500.00);

        assertNotNull(item);
        assertEquals("item101", item.getId());
        assertEquals("Tyres", item.getCategory());
        assertEquals("Goodyear Eagle", item.getProductName());
        assertEquals(2, item.getQuantity());
        assertEquals(1500.00, item.getPrice());
    }

    @Test
    void testCreateWithoutId() {
        OrderItem item = OrderItemFactory.create("Batteries", "Exide Premium", 1, 1200.00);

        assertNotNull(item);
        assertNotNull(item.getId()); // ID should be auto-generated
        assertEquals("Batteries", item.getCategory());
        assertEquals("Exide Premium", item.getProductName());
        assertEquals(1, item.getQuantity());
        assertEquals(1200.00, item.getPrice());
    }
}

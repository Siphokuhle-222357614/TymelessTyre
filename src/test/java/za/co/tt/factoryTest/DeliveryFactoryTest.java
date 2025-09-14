package za.co.tt.factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Delivery;
import za.co.tt.factory.DeliveryFactory;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class DeliveryFactoryTest {

    public static Delivery delivery1 = DeliveryFactory.createDelivery(1001L,
            "Out for Delivery", "Fast Courier",
            LocalDateTime.of(2024, 12, 25, 14, 30)
    );

    public static Delivery delivery2 = DeliveryFactory.createDelivery(null,
            "Processing", "Fast Courier", LocalDateTime.now()
    );

    @Test
    public void testCreateDeliveryWithAllAttributes() {
        assertNotNull(delivery1);
        System.out.println(delivery1);
    }

    @Test
    public void testCreateDeliveryThatFails() {
        assertNotNull(delivery2);
        System.out.println(delivery2);
    }
}
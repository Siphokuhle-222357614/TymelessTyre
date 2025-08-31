package za.co.tt.factory;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Order;
import za.co.tt.domain.User;
import za.co.tt.domain.Address;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class OrderFactoryTest {

    @Test
    void testCreateOrder() {
        User user = mock(User.class);
        Address address = mock(Address.class);
        Order order = OrderFactory.createOrder(user, LocalDate.now(), address, "NEW", BigDecimal.TEN, "CARD");

        assertNotNull(order);
        assertEquals(user, order.getUser());
        assertEquals(address, order.getShippingAddress());
        assertEquals("NEW", order.getStatus());
        assertEquals(BigDecimal.TEN, order.getTotalAmount());
        assertEquals("CARD", order.getPaymentMethod());
    }
}
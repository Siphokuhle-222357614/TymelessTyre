package za.co.tt.serviceTest;

import za.co.tt.service.OrderService;
import org.junit.jupiter.api.Test;
import za.co.tt.domain.Order;
import za.co.tt.repository.OrderRepository;
import za.co.tt.service.impl.OrderServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Test
    void testSaveOrder() {
        OrderRepository repo = mock(OrderRepository.class);
        OrderService service = new OrderServiceImpl(repo);
        Order order = mock(Order.class);

        when(repo.save(order)).thenReturn(order);
        Order saved = service.save(order);

        assertEquals(order, saved);
    }
}


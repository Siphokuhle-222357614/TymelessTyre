//package za.co.tt.controller;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.http.ResponseEntity;
//import za.co.tt.domain.Order;
//import za.co.tt.service.OrderService;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class OrderControllerTest {
//
//    @Test
//    void testGetOrder() {
//        OrderService service = mock(OrderService.class);
//        OrderController controller = new OrderController(service);
//        Order order = mock(Order.class);
//
//        when(service.findById(1L)).thenReturn(Optional.of(order));
//        ResponseEntity<Order> response = controller.getOrder(1L);
//
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(order, response.getBody());
//    }
//}
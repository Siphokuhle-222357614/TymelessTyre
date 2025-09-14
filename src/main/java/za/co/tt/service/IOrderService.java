package za.co.tt.service;

import za.co.tt.domain.Order;
import java.util.List;
import java.util.Optional;

public interface IOrderService extends IService<Order, String> {

    Order createOrder(Order order);

    Optional<Order> getOrderById(String id);

    List<Order> getAllOrders();

    Order updateOrder(Order order);

    void deleteOrder(String id);

    void deleteById(Long id);

    Order read(Long id);
}
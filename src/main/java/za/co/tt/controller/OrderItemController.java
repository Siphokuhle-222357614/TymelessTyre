package za.co.tt.controller;

import org.springframework.web.bind.annotation.*;
import za.co.tt.domain.OrderItem;

import java.util.*;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    private final Map<String, OrderItem> orderItemDB = new HashMap<>();

    @PostMapping("/create")
    public OrderItem create(@RequestBody OrderItem orderItem) {
        orderItemDB.put(orderItem.getId(), orderItem);
        return orderItem;
    }

    @GetMapping("/read/{id}")
    public OrderItem read(@PathVariable String id) {
        return orderItemDB.get(id);
    }

    @GetMapping("/getAll")
    public List<OrderItem> getAll() {
        return new ArrayList<>(orderItemDB.values());
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return orderItemDB.remove(id) != null;
    }
}

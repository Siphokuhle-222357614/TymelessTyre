//package za.co.tt.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import za.co.tt.domain.CartItem;
//import za.co.tt.domain.OrderItem;
//import za.co.tt.service.impl.CartItemServiceImpl;
//import za.co.tt.service.impl.OrderItemServiceImpl;
//
//import java.util.*;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:5173")
////@CrossOrigin(origins = "*")
//@RequestMapping("api/orderItem")
//public class OrderItemController {
//
//    @Autowired
//    private OrderItemServiceImpl service;
////    private final Map<String, OrderItem> orderItem = new HashMap<>();
//
//    @PostMapping("api/create")
//    public OrderItem create(@RequestBody OrderItem orderItem) {
//        return service.create(orderItem);
//    }
//
//    @GetMapping("api/read/{id}")
//    public OrderItem read(@PathVariable String id) {
//        return orderItem.get(id);
//    }
//
//    @PostMapping("api/update")
//    public OrderItem update(@RequestBody OrderItem orderItem) {
//        return service.update(orderItem);
//    }
//
//    @DeleteMapping("api/delete/{id}")
//    public boolean delete(@PathVariable String id) {
//        return service.delete(id);
//    }
//
//    @GetMapping("api/getAll")
//    public Set<OrderItem> getAll() {
//        return service.getAll();
//    }
//}

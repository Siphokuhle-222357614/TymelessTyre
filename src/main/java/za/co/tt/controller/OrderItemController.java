// src/main/java/za/co/tt/controller/OrderItemController.java
package za.co.tt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tt.domain.OrderItem;
import za.co.tt.factory.OrderItemFactory;
import za.co.tt.service.IOrderItemService;

import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    private final IOrderItemService service;

    public OrderItemController(IOrderItemService service) {
        this.service = service;
    }

    // 1) Create via JSON body
    @PostMapping
    public ResponseEntity<OrderItem> create(@RequestBody OrderItem body) {
        // if client didn't send id, create one
        OrderItem item = (body.getId() == null || body.getId().isBlank())
                ? OrderItemFactory.create(body.getCategory(), body.getProductName(), body.getQuantity(), body.getPrice())
                : OrderItemFactory.create(body.getId(), body.getCategory(), body.getProductName(), body.getQuantity(), body.getPrice());
        return ResponseEntity.ok(service.save(item));
    }

    // 2) Create via simple params (super simple for demos/lecturers)
    @PostMapping("/simple")
    public ResponseEntity<OrderItem> createSimple(@RequestParam String id,
                                                  @RequestParam String category,
                                                  @RequestParam String productName,
                                                  @RequestParam int quantity,
                                                  @RequestParam double price) {
        OrderItem item = OrderItemFactory.create(id, category, productName, quantity, price);
        return ResponseEntity.ok(service.save(item));
    }

    // 3) Read all
    @GetMapping
    public ResponseEntity<List<OrderItem>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // 4) Read one
    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getById(@PathVariable String id) {
        return ResponseEntity.ok(
                service.findById(id).orElseThrow(() -> new RuntimeException("OrderItem not found: " + id))
        );
    }

    // 5) Update
    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> update(@PathVariable String id, @RequestBody OrderItem body) {
        return ResponseEntity.ok(service.update(id, body));
    }

    // 6) Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

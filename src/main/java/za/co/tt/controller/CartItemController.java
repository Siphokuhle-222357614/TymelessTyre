/*Author: Bonke Bulana - 220539995*/
package za.co.tt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.tt.domain.CartItem;
import za.co.tt.service.impl.CartItemServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {

    @Autowired
    private CartItemServiceImpl service;

    @PostMapping("/create")
    public CartItem create(@RequestBody CartItem cartItem) {
        return service.create(cartItem);
    }

    @GetMapping("/read/{id}")
    public CartItem read(@PathVariable Long id) {
        return service.read(id);
    }

    @PostMapping("/update")
    public CartItem update(@RequestBody CartItem cartItem) {
        return service.update(cartItem);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        service.delete(id);
        return true;
    }

    @GetMapping("/getAll")
    public List<CartItem> getAll() {
        return service.getAll();
    }
}


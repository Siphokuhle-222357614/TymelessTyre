/*
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */
package za.co.tt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import za.co.tt.domain.Address;
import za.co.tt.service.impl.AddressServiceImpl;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
//@CrossOrigin(origins = "*")
@RequestMapping("api/address")
public class AddressController {

    private AddressServiceImpl service;

    @Autowired
    AddressController(AddressServiceImpl service) {
        this.service = service;
    }

    @PostMapping("api/create")
    public Address create(@RequestBody Address address) {
        return service.create(address);
    }

    @GetMapping("api/read/{id}")
    public Address read(@PathVariable Long id) {
        return service.read(id);
    }

    @PostMapping("api/update")
    public Address update(@RequestBody Address address) {
        return service.update(address);
    }

    @DeleteMapping("api/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        service.delete(id);
        return true;
    }

    @GetMapping("api/getAll")
    public List<Address> getAll() {
        return service.findAll();
    }
}




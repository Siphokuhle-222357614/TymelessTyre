package za.co.tt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tt.domain.Address;
import za.co.tt.domain.User;
import za.co.tt.repository.UserRepository;
import za.co.tt.service.AddressService;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;
    private final UserRepository userRepository;

    @Autowired
    public AddressController(AddressService addressService, UserRepository userRepository) {
        this.addressService = addressService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Optional<Address> address = addressService.findById(id);
        return address.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Address>> getAddressesByUser(@PathVariable Long userId) {
        List<Address> addresses = addressService.findByUserId(userId);
        return ResponseEntity.ok(addresses);
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        if (address.getUser() == null || address.getUser().getUserId() == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<User> user = userRepository.findById(address.getUser().getUserId());
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        address.setUser(user.get());
        Address savedAddress = addressService.save(address);
        return ResponseEntity.ok(savedAddress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(
            @PathVariable Long id,
            @RequestBody Address address) {

        if (!id.equals(address.getAddressId())) {
            return ResponseEntity.badRequest().build();
        }

        Optional<User> user = userRepository.findById(address.getUser().getUserId());
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        address.setUser(user.get());

        Address updatedAddress = addressService.update(address);
        return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

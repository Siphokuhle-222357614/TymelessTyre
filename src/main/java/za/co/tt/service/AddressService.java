package za.co.tt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.tt.domain.Address;
import za.co.tt.domain.Cart;
import za.co.tt.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address entity) {
        return addressRepository.save(entity);
    }

    @Override
    public Address update(Address entity) {
        if (entity.getAddressId() == null) {
            throw new IllegalArgumentException("Address ID cannot be null for update.");
        }
        if (!addressRepository.existsById(entity.getAddressId())) {
            throw new IllegalArgumentException("Address with ID " + entity.getAddressId() + " not found.");
        }
        return addressRepository.save(entity);
    }

    @Override
    public ResponseEntity<Cart> deleteById(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new IllegalArgumentException("Address with ID " + id + " not found.");
        }
        addressRepository.deleteById(id);
        return null;
    }

    @Override
    public Address read(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> findByUserId(Long userId) {
        return addressRepository.findByUserId(userId);
    }
}

/*
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */
package za.co.tt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import za.co.tt.domain.Address;
import za.co.tt.repository.AddressRepository;
import za.co.tt.service.IAddressService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    private final AddressRepository repository;

    @Autowired
    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address create(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        return repository.save(address);
    }

    @Override
    public Address read(Long addressId) {
        if (addressId == null) {
            throw new IllegalArgumentException("Address ID cannot be null");
        }
        return repository.findById(addressId)
                .orElseThrow(() -> new EntityNotFoundException("Address with ID " + addressId + " not found"));
    }

    @Override
    public Address update(Address address) {
        if (address == null || address.getId() == null) {
            throw new IllegalArgumentException("Address or Address ID cannot be null");
        }

        if (!repository.existsById(address.getId())) {
            throw new EntityNotFoundException("Address with ID " + address.getId() + " not found");
        }

        return repository.save(address);
    }

    @Override
    public void delete(Long addressId) {
        if (addressId == null) {
            throw new IllegalArgumentException("Address ID cannot be null");
        }

        try {
            repository.deleteById(addressId);
        } catch (EmptyResultDataAccessException ex) {
            throw new EntityNotFoundException("Address with ID " + addressId + " not found");
        }
    }

    @Override
    public List<Address> findAll() {
        return repository.findAll();
    }
}

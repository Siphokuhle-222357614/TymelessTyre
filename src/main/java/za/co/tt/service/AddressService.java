package za.co.tt.service;


import za.co.tt.domain.Address;
import java.util.List;

public interface AddressService{
    Address create(Address address);
    Address read(Long addressId);
    Address update(Address address);
    void delete(Long addressId);
    List<Address> findAll();
}

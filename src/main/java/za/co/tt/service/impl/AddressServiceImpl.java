package za.co.tt.service.impl;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import za.co.tt.domain.Address;
//import za.co.tt.repository.AddressRepository;
//
//import java.util.List;
//
//
//@Service
//public class AddressServiceImpl implements AddressService{
//
//    private final AddressRepository repository;
//
//
//    @Autowired
//    public AddressServiceImpl(AddressRepository repository) {
//        this.repository = repository;
//
//    }
//    @Override
//    public Address create(Address address) {
//        if (address == null || address.getId() == null) {
//            return null;
//        }
//        return repository.save(address);
//    }
//    @Override
//    public Address read(Long addressId) {
//        return repository.findById(addressId)
//                .orElse(null);
//
//    }
//    @Override
//    public Address update(Address address) {
//        if (address == null || address.getId() == null) {
//            return null;
//        }
//        return repository.save(address);
//    }
//    @Override
//    public void delete(Long addressId) {
//        if (addressId != null) {
//            repository.deleteById(addressId);
//        }
//    }
//    @Override
//    public List<Address> findAll() {
//        return repository.findAll();
//    }
//
//
//
//}

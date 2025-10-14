package za.co.tt.service;

import za.co.tt.domain.Address;
import java.util.*;


public interface IAddressService extends IService<Address, Long> {

    Optional<Address> findById(Long id);
    List<Address> findByUserId(Long userId);
}

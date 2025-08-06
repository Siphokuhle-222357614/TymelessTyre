package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.tt.domain.Address;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByStreetAndCity(String street, String city);
    Address findByPostalCode(String postalCode);
    Address findByStreetAndPostalCode(String street, String postalCode);
    Address findByCityAndPostalCode(String city, String postalCode);
    List<Address> findAllByCity(String city);
}

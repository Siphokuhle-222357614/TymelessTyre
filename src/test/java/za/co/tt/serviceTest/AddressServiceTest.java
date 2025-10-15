package za.co.tt.serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.tt.domain.Address;
import za.co.tt.domain.User;
import za.co.tt.repository.AddressRepository;
import za.co.tt.repository.UserRepository;
import za.co.tt.service.AddressService;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    private User testUser;

    @BeforeEach
    public void setUp() {
        addressRepository.deleteAll();
        userRepository.deleteAll();

        testUser = new User.Builder()
                .setUsername("B.Bulan")
                .setEmail("B@gmail.com")
                .setPassword("B12")
                .build();

        testUser = userRepository.save(testUser);
    }

    @Test
    public void testSaveAddress() {
        Address address = new Address();
        address.setStreet("St CPT Marks");
        address.setCity("Cape Town");
        address.setState("Western Cape");
        address.setPostalCode(8004);
        address.setCountry("South Africa");
        address.setUser(testUser);

        Address saved = addressService.save(address);

        assertNotNull(saved.getAddressId());
        assertEquals("St CPT Marks", saved.getStreet());
        assertEquals(testUser.getUserId(), saved.getUser().getUserId());
    }

    @Test
    public void testFindByUserId() {
        Address address1 = new Address();
        address1.setStreet("St CPT Marks");
        address1.setUser(testUser);
        addressService.save(address1);

        Address address2 = new Address();
        address2.setStreet("Sir Lowry");
        address2.setUser(testUser);
        addressService.save(address2);

        List<Address> addresses = addressService.findByUserId(testUser.getUserId());

        assertEquals(2, addresses.size());
        assertTrue(addresses.stream().anyMatch(a -> a.getStreet().equals("St CPT Marks")));
        assertTrue(addresses.stream().anyMatch(a -> a.getStreet().equals("Sir Lowry")));
    }

    @Test
    public void testUpdateAddress() {
        Address address = new Address();
        address.setStreet("Jason Street");
        address.setUser(testUser);
        address = addressService.save(address);

        address.setStreet("Updated Street");
        Address updated = addressService.update(address);

        assertEquals("Updated Street", updated.getStreet());
    }

    @Test
    public void testDeleteAddress() {
        Address address = new Address();
        address.setStreet("Jason Street");
        address.setUser(testUser);
        address = addressService.save(address);

        Long id = address.getAddressId();
        addressService.deleteById(id);

        Optional<Address> deleted = addressService.findById(id);
        assertTrue(deleted.isEmpty());
    }
}

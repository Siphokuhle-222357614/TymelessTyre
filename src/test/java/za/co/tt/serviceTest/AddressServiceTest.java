//package za.co.tt.service;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//import za.co.tt.domain.Address;
//import za.co.tt.domain.User;
//import za.co.tt.repository.AddressRepository;
//import za.co.tt.repository.UserRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
////@Transactional
//public class AddressServiceTest {
//
//    @Autowired
//    private AddressService addressService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private AddressRepository addressRepository;
//
//    private User testUser;
//
//    @BeforeEach
//    public void setUp() {
//        testUser = new User.Builder()
//                .setUsername("BonkeBul")
//                .setEmail("b.bulana@gmail.com")
//                .setPassword("bb123")
//                .build();
//        testUser = userRepository.save(testUser);
//    }
//
//    @Test
//    public void testSaveAddress() {
//        Address address = new Address();
//        address.setStreet("Hanover Street");
//        address.setCity("Cape Town");
//        address.setState("Western Cape");
//        address.setPostalCode("8001");
//        address.setCountry("South Africa");
//        address.setUser(testUser);
//
//        Address saved = addressService.save(address);
//
//        assertNotNull(saved.getAddressId());
//        assertEquals("Hanover Street", saved.getStreet());
//        assertEquals(testUser.getUserId(), saved.getUser().getUserId());
//    }
//
//    @Test
//    public void testFindByUserId() {
//        Address address1 = new Address();
//        address1.setStreet("Hanover Street");
//        address1.setUser(testUser);
//        addressService.save(address1);
//
//        Address address2 = new Address();
//        address2.setStreet("123 Parklands Street");
//        address2.setUser(testUser);
//        addressService.save(address2);
//
//        List<Address> addresses = addressService.findByUserId(testUser.getUserId());
//
//        assertEquals(2, addresses.size());
//        assertTrue(addresses.stream().anyMatch(a -> a.getStreet().equals("Hanover Street")));
//        assertTrue(addresses.stream().anyMatch(a -> a.getStreet().equals("123 Parklands Street")));
//    }
//
//    @Test
//    public void testUpdateAddress() {
//        Address address = new Address();
//        address.setStreet("Micheal Street");
//        address.setUser(testUser);
//        address = addressService.save(address);
//
//        address.setStreet("Updated Street");
//        Address updated = addressService.update(address);
//
//        assertEquals("Updated Street", updated.getStreet());
//    }
//
//    @Test
//    public void testDeleteAddress() {
//        Address address = new Address();
//        address.setStreet("Micheal Street");
//        address.setUser(testUser);
//        address = addressService.save(address);
//
//        Long id = address.getAddressId();
//        addressService.deleteById(id);
//
//        Optional<Address> deleted = addressService.findById(id);
//        assertTrue(deleted.isEmpty());
//    }
//}

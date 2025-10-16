package za.co.tt.controllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.co.tt.domain.Address;
import za.co.tt.domain.Enum.AddressType;
import za.co.tt.domain.User;
import za.co.tt.repository.AddressRepository;
import za.co.tt.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

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

        testUser = userRepository.saveAndFlush(testUser);
    }


    @Test
    public void testCreateAddress() {
        Address address = new Address.Builder()
                .setStreet("123 Main Street")
                .setCity("Cape Town")
                .setState("Western Cape")
                .setPostalCode(8001)
                .setCountry("South Africa")
                .setAddressType(AddressType.HOME)
                .setUser(testUser)
                .build();

        ResponseEntity<Address> response = restTemplate.postForEntity(
                "/api/addresses", address, Address.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("123 Main Street", response.getBody().getStreet());
    }

    @Test
    public void testGetAllAddresses() {
        Address address1 = new Address.Builder()
                .setStreet("St CPT Marks")
                .setUser(testUser)
                .build();
        Address address2 = new Address.Builder()
                .setStreet("Sir Lowry")
                .setUser(testUser)
                .build();
        addressRepository.save(address1);
        addressRepository.save(address2);

        ResponseEntity<Address[]> response = restTemplate.getForEntity(
                "/api/addresses", Address[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().length);
    }

    @Test
    public void testGetAddressById() {
        Address address = new Address.Builder()
                .setStreet("Jason Street")
                .setUser(testUser)
                .setAddressType(AddressType.HOME)
                .setPostalCode(8001)
                .setCity("Cape Town")
                .setCountry("South Africa")
                .setState("Western Cape")
                .build();
        address = addressRepository.save(address);

        ResponseEntity<Address> response = restTemplate.getForEntity(
                "/api/addresses/" + address.getAddressId(), Address.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Jason Street", response.getBody().getStreet());
    }

    @Test
    public void testUpdateAddress() {
        Address address = new Address.Builder()
                .setStreet("Old Street")
                .setUser(testUser)
                .build();
        address = addressRepository.save(address);

        address.setStreet("Updated Street");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Address> entity = new HttpEntity<>(address, headers);

        ResponseEntity<Address> response = restTemplate.exchange(
                "/api/addresses/" + address.getAddressId(),
                HttpMethod.PUT,
                entity,
                Address.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated Street", response.getBody().getStreet());
    }

    @Test
    public void testDeleteAddress() {
        Address address = new Address.Builder()
                .setStreet("Delete Street")
                .setUser(testUser)
                .build();
        address = addressRepository.save(address);

        restTemplate.delete("/api/addresses/" + address.getAddressId());

        assertFalse(addressRepository.findById(address.getAddressId()).isPresent());
    }

    @Test
    public void testGetAddressesByUserId() {
        Address address1 = new Address.Builder()
                .setStreet("St CPT Marks")
                .setUser(testUser)
                .build();
        Address address2 = new Address.Builder()
                .setStreet("Sir Lowry")
                .setUser(testUser)
                .build();
        addressRepository.save(address1);
        addressRepository.save(address2);

        ResponseEntity<Address[]> response = restTemplate.getForEntity(
                "/api/addresses/user/" + testUser.getUserId(), Address[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().length);
    }
}

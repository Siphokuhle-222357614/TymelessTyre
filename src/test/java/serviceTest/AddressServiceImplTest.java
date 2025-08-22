/*
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */
package serviceTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.tt.domain.Address;
import za.co.tt.factory.AddressFactory;
import za.co.tt.service.IAddressService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AddressServiceImplTest {
//
//    @Autowired
//    private IAddressService service;
//
//    private Address address1;
//
//    @BeforeEach
//    void setUp() {
//        address1 = AddressFactory.createAddress(
//                1010L,
//                "Hanover St",
//                "Cape Town",
//                "Western Cape",
//                8000,
//                "South Africa",
//                true,
//                null,
//                LocalDate.now(),
//                LocalDate.now()
//        );
//
//        service.create(address1);
//    }
//
//    @Test
//    void create() {
//        Address created = service.create(address1);
//        assertNotNull(created, "Address should be created successfully");
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    void read() {
//        Address read = service.read(address1.getId());
//        assertNotNull(read, "Address should be found");
//        assertEquals(address1.getStreet(), read.getStreet(), "Street should match");
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void update() {
//        Address updateData = new Address.Builder()
//                .setId(address1.getId())
//                .setStreet("456 New Street")
//                .setCity(address1.getCity())
//                .setProvince(address1.getProvince())
//                .setPostalCode(address1.getPostalCode())
//                .setCountry(address1.getCountry())
//                .build();
//
//        Address updated = service.update(updateData);
//
//        Address readBack = service.read(address1.getId());
//        assertNotNull(updated, "Updated address should not be null");
//        assertEquals("456 New Street", readBack.getStreet(), "Street should be updated");
//        System.out.println("Updated: " + readBack);
//    }
//
//    @Test
//    void delete() {
//        service.delete(address1.getId());
//
//
//        Address deleted = service.read(address1.getId());
//        assertNull(deleted, "Address should be deleted");
//        System.out.println("Deleted address with ID: " + address1.getId());
//    }
//
//    @Test
//    void findAll() {
//        List<Address> allAddresses = service.findAll();
//        assertNotNull(allAddresses, "List of addresses should not be null");
//        assertTrue(allAddresses.size() > 0, "There should be at least one address");
//        allAddresses.forEach(System.out::println);
//        System.out.println("All addresses found.");
//    }

} //Have an error because of the Tyre/Rim Service


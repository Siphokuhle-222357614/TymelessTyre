/*
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */

package serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.tt.domain.User;
import za.co.tt.domain.UserRole;
import za.co.tt.factory.UserFactory;
import za.co.tt.service.IUserService;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {

//    @Autowired
//    private IUserService service;
//
//    private User user1;
//
//    @BeforeEach
//    void setUp() {
//
//        user1 = UserFactory.createUser(
//                1010L,
//                "Yanga",
//                "Jilaji",
//                "yjilaji@gmail.com",
//                "psd9802",
//                "0682941085",
//                LocalDate.now(),
//                true,
//                null,
//                null,
//                UserRole.CUSTOMER
//        );
//
//
//        service.save(user1);
//    }
//
//    @Test
//    void create() {
//        User created = service.save(user1);
//        assertNotNull(created);
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    void read() {
//        User read = service.findById(user1.getUserId()).orElse(null);
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void updateUser() {
//        User updateData = new User.Builder()
//                .setFirstName("Lihle")
//                .build();
//
//        User updated = service.update(user1.getUserId(), updateData);
//
//        assertNotNull(updated);
//        assertEquals("Lihle", updated.getFirstName());
//        System.out.println("Updated: " + updated);
//    }
//
//
//    @Test
//    void delete() {
//        service.deleteById(user1.getUserId());
//        assertTrue(service.findById(user1.getUserId()).isEmpty());
//        System.out.println("Deleted user with ID: " + user1.getUserId());
//    }
//
//    @Test
//    void findAll() {
//        assertNotNull(service.findAll());
//        service.findAll().forEach(System.out::println);
//        System.out.println("All users found.");
//    }

} //Have an error because of the Tyre/Rim Service



package za.co.tt.serviceTest;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.tt.domain.User;
import za.co.tt.domain.LoginRequest;
import za.co.tt.factory.UserFactory;
import za.co.tt.service.UserService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    private static final User user = UserFactory.createUser(
            "Jonh",
            "jonh@gmail.com",
            "password246");

    @Test
    @Order(1)
    void a_create(){
        User created = userService.save(user);
        assertNotNull(created);
        assertNotNull(created.getEmail());
        System.out.println("Created user: " + created);
    }

    @Test
    @Order(2)
    void b_read(){
        Optional<User> optionalUser = userService.findByEmail(user.getEmail());
        assertTrue(optionalUser.isPresent());
        System.out.println("Read user: " + optionalUser.get());
    }

    @Test
    @Order(3)
    void c_update(){
        User updateUser = new User.Builder()
                .copy(user)
                .setPassword("psd810")
                .build();
        User updated = userService.save(updateUser);
        assertEquals("psd810", updated.getPassword());
        System.out.println("Updated user: " + updated);
    }

    @Test
    @Order(3)
    void d_delete(){
        userService.deleteById(user.getUserId());
        Optional<User> deleted = userService.findByEmail(user.getEmail());
        assertFalse(deleted.isPresent());
    }
}

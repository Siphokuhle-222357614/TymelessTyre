package za.co.tt.factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.User;
import za.co.tt.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;


public class UserFactoryTest {

    @Test
    void createUserWithRole() {
        User customerUser = UserFactory.createUser(
                "Rowan",
                "Brown",
                "RowanB",
                "rown.b@gmail.com",
                "password123",
                "CUSTOMER"
        );
        assertNotNull(customerUser);
        assertEquals("CUSTOMER", customerUser.getRole());
        System.out.println("Customer: " + customerUser);
    }

    @Test
    void createUserAsCustomer() {
        User customer = UserFactory.createCustomer(
                "Alice",
                "Green",
                "AliceB",
                "alice.b@gmail.com",
                "pass4564"
        );
        assertNotNull(customer);
        assertEquals("CUSTOMER", customer.getRole());
        System.out.println("CUSTOMER: " + customer);
    }

    @Test
    void createUserAsAdmin() {
        User admin = UserFactory.createAdmin(
                "Rose",
                "Barcelona",
                "AdminBarcelona",
                "rose@admin.com",
                "0104adm"
        );
        assertNotNull(admin);
        assertEquals("ADMIN", admin.getRole());
        System.out.println("ADMIN: " + admin);
    }
}


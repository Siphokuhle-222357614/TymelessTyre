package za.co.tt.factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.User;
import za.co.tt.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserFactoryTest {

    @Test
    void createUser() {
        User user = UserFactory.createUser("RowanBrown",
                "rown.b@gmail.com",
                "password123");

        assertNotNull(user);
        System.out.println(user.toString());

    }
}

/*Author: Bonke Bulana - 220539995*/
package za.co.tt.serviceTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import za.co.tt.domain.Register;
import za.co.tt.factory.RegisterFactory;
import za.co.tt.service.impl.RegisterServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class RegisterServiceImplTest {

    @Autowired
    private RegisterServiceImpl registerService;

    private static Register register = RegisterFactory.createRegister(1234L, "Victor", "Zoe","VictorZoe@gmail.com",
            "Amazonian123",true, false, null
    );

    @Test
    void create() {
        System.out.println("Created: ");
        Register created = registerService.create(register);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void read() {
        System.out.println("Read: ");
        Register read = registerService.read(register.getUserId());
        assertNotNull(read);
        assertEquals(register.getUserId(), read.getUserId());
        System.out.println(read);
    }

    @Test
    void update() {
        Register updated = registerService.update(new Register.Builder()
                .copy(register)
                .setFirstName("Jane")
                .build());
        System.out.println("Updated: ");
        assertNotNull(updated);
        assertEquals("Jane", updated.getFirstName());
        System.out.println(updated);
    }

    @Test
    void delete() {
        System.out.println("Deleted: ");
        Register deleted = registerService.delete(register.getUserId());
        assertNotNull(deleted);
        System.out.println(deleted);
    }

    @Test
    void getAll() {
        System.out.println("All Registers: ");
        assertNotNull(registerService.getAll());
        System.out.println(registerService.getAll());
    }
}

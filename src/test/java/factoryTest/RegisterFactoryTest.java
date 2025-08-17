/*Author: Bonke Bulana*/
package factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Register;
import za.co.tt.factory.RegisterFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RegisterFactoryTest {

    Register register1 = RegisterFactory.createRegister(null, "John", "Stevens", "johnST@gmail.com",
            "JoHN772", false, true, LocalDate.now()
    );

    Register register2 = RegisterFactory.createRegister(30474L, "Alice", "Smith",
            "alicesmith@gmail.com", "ZEroden456", true, true, LocalDate.now()
    );


    @Test
    public void createTestThatFails() {
        assertNotNull(register1);
        System.out.println(register1);
    }

    @Test
    public void createTestThatPasses() {
        assertNotNull(register2);
        System.out.println(register2);
    }



}

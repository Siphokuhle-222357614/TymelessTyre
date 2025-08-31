/*Author: Bonke Bulana*/
package za.co.tt.factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Register;
import za.co.tt.factory.RegisterFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RegisterFactoryTest {

    Register register1 = RegisterFactory.createRegister(30578L, "John", "Stevens", "johnST@gmail.com",
            null, false, true, LocalDate.now()
    );

    Register register2 = RegisterFactory.createRegister(30474L, "Samkelo", "Smith",
            "samkelosmith@gmail.com", "ZEroden456", true, true, LocalDate.now()
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

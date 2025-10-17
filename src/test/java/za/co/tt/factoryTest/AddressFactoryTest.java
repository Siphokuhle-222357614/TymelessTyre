package za.co.tt.factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Address;
import za.co.tt.domain.Enum.AddressType;
import za.co.tt.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AddressFactoryTest {

    @Test
    void createAddress(){
        Address address1 = AddressFactory.createAddress("Micheal Street",
                "Strand",
                "Asanda Village",
                7140,
                "South Africa",
                AddressType.HOME);

        assertNotNull(address1);
        System.out.println(address1);
    }
}

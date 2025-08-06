package factoryTest;


import org.junit.jupiter.api.Test;
import za.co.tt.domain.Address;
//import za.co.tt.domain.Payment;
import za.co.tt.domain.User;
import za.co.tt.factory.AddressFactory;
import za.co.tt.factory.UserFactory;

import java.time.LocalDate;



import static factoryTest.UserFactoryTest.addressList;
import static factoryTest.UserFactoryTest.paymentsList;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AddressFactoryTest {


    User testUser = UserFactory.createUser(1002L, "John", "Doe",
            "doe@gmail.com",
            "psd123", "0780298461", LocalDate.now(), false, true, addressList,
            paymentsList);

    User testUser1 = UserFactory.createUser(1003L, "Lwazi", "Mthethwa",
            "mthethwa@gmail.com", "psd456", "0781037298", LocalDate.now(),
            true, true, addressList, paymentsList);



    Address address1 = AddressFactory.createAddress(1020L, "123 Hanover st", "Cape Town",
            "Western Cape", 8000, "South Africa", true, null,
            LocalDate.now(),
            LocalDate.now());

    Address address2 = AddressFactory.createAddress1(1021L, "456 Micheal st", "Strand",
            "Western Cape", 7140, "South Africa", testUser1,
            LocalDate.now(),
            LocalDate.now());

    Address address3 = AddressFactory.createAddress(1022L, "ST Marks", "Cape Town",
            "Western Cape", 8002, "South Africa", true, testUser,
            LocalDate.now(),
            LocalDate.now());


    @Test
    public void createTestThatFails(){
        assertNotNull(address1);
        System.out.println(address1);
    }
    @Test
    public void createTestThatPasses(){
        assertNotNull(address2);
        System.out.println(address2);
    }

    @Test
    public void createTestThatPasses2() {
        assertNotNull(address3);
        System.out.println(address3);

    }
}

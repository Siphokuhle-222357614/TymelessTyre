/*AddressFactoryTest
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */

package za.co.tt.factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Address;
import za.co.tt.domain.User;
import za.co.tt.factory.AddressFactory;
import za.co.tt.factory.UserFactory;

import java.time.LocalDate;

import static za.co.tt.factoryTest.UserFactoryTest.addressList;
import static za.co.tt.factoryTest.UserFactoryTest.paymentsList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static za.co.tt.domain.UserRole.CUSTOMER;

public class AddressFactoryTest {


    User testUser = UserFactory.createUser(1002L, "John", "Doe",
            "doe@gmail.com",
            "psd123", "0780298461", LocalDate.now(), true, addressList,
            paymentsList, CUSTOMER);

    //       User testUser1 = UserFactory.createUser(1003L, "Lwazi", "Mthethwa",
//               "mthethwa@gmail.com", "psd456", "0781037298", LocalDate.now(),
//               ADMIN, true, addressList, paymentsList);



    Address address1 = AddressFactory.createAddress(1020L, "123 Hanover st", "Cape Town",
            "Western Cape", 8000, "South Africa", true, null,
            LocalDate.now(),
            LocalDate.now());

    Address address2 = AddressFactory.createAddress(1021L, "456 Micheal st", "Strand",
            "Western Cape", 7140, "South Africa",true, testUser,
            LocalDate.now(),
            LocalDate.now());

    Address address3 = AddressFactory.createAddress(1022L, "ST Marks", "Cape Town",
            "Western Cape", 8002, "South Africa", false, testUser,
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

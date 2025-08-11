/*UserFactoryTest
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */

package factoryTest;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.co.tt.domain.Address;
import za.co.tt.domain.Payment;
import za.co.tt.domain.User;
import za.co.tt.domain.UserRole;
import za.co.tt.factory.AddressFactory;
import za.co.tt.factory.PaymentFactory;
import za.co.tt.factory.UserFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserFactoryTest {



    static List<Address> addressList = new ArrayList<>();

    static {

        addressList.add(AddressFactory.createAddress(
                1L, "123 Main St", "Cape Town", "Western Cape",
                8000, "South Africa", false, null, LocalDate.now()
                , LocalDate.now()));
        addressList.add(AddressFactory.createAddress(
                2L, "456 Second St", "Strand","Western Cape", 7140,
                "South Africa", true, null, LocalDate.now(), LocalDate.now()));
    }
    static List<Payment> paymentsList = new ArrayList<>();
    static{
        paymentsList.add(PaymentFactory.createPayment(002L, "Card",
                "Successful",
                2500.00, LocalDate.now(), null, null));
    }

    static User user1 = UserFactory.createUser(001L, "John", "Doe",
            "doe.gmail.com",
            "password123", "07829847", LocalDate.now(),
            true, addressList, paymentsList, UserRole.CUSTOMER);

    User user2 = UserFactory.createUser(002L, "Luyanda", "Mabasa",
            "mabasal@gmail.com",
            "psd2025", "0797192985", LocalDate.now(),
            true, addressList, paymentsList, UserRole.ADMIN);



    @Test
    @Order(1)
    public void createUserTestThatFails() {
        assertNotNull(user1);
        System.out.println(user1);
    }

    @Test
    @Order(2)
    public void createUserTestThatPasses(){
        assertNotNull(user2);
        System.out.println(user2);
    }


}

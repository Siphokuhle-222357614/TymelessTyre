/*Author: Bonke Bulana*/
package factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Payment;
import za.co.tt.factory.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class PaymentFactoryTest {

    public static Payment payment1 = PaymentFactory.createPayment(123456, "Credit", "Rejected", 750, LocalDate.of(2025,7,11) , null, null);
    public static Payment payment2 = PaymentFactory.createPayment(12345, "Debit", "Approved", 345, LocalDate.of(2024,13,12), null, null);

    @Test
    public void testCreateUserWithAllAttributes() {
        assertNotNull(payment1);
        System.out.println(payment1);
    }

    @Test
    public void testCreateUserThatFails() {
        //fail();
        assertNotNull(payment2);
        System.out.println(payment2);
    }

}
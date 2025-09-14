package za.co.tt.factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.Payment;
import za.co.tt.domain.User;
import za.co.tt.domain.Order;
import za.co.tt.factory.PaymentFactory;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    private static User testUser = new User.Builder().setUserId(1345L)
            .setUsername("Simnikiwe").setEmail("SimnikiweJokhwe@gmail.com")
            .build();

    private static Order testOrder = new Order.Builder()
            .setOrderId("TEST_ORDER")
            .build();

    public static Payment payment1 = PaymentFactory.createPayment("Debit", "Approved", 750,
            LocalDate.of(2024,7,11), testUser, testOrder
    );

    public static Payment payment2 = PaymentFactory.createPayment("Credit",
            "Rejected", 345, null, testUser, testOrder
    );

    @Test
    public void testCreatePaymentWithAllAttributes() {
        assertNotNull(payment1);
        System.out.println("Successfully created: " + payment1);
    }

    @Test
    public void testCreatePaymentThatFails() {
        assertNotNull(payment2);
        System.out.println(payment2);
    }
}
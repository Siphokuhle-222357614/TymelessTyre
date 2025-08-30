/*Author: Bonke Bulana - 220539995*/
package serviceTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.tt.domain.Order;
import za.co.tt.domain.Payment;
import za.co.tt.domain.User;
import za.co.tt.factory.PaymentFactory;
import za.co.tt.service.impl.PaymentServiceImpl;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class PaymentServiceImplTest {

    @Autowired
    private PaymentServiceImpl paymentService;

    private static User user = new User();
    private static Order order = new Order();

    private static Payment payment = PaymentFactory.createPayment(1L, "Credit Card",
            "Completed", 1500.00, LocalDate.now(), user, order);

    @Test
    void create() {
        System.out.println("Created: ");
        Payment created = paymentService.create(payment);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void read() {
        System.out.println("Read: ");
        Payment read = paymentService.read(payment.getPaymentId());
        assertNotNull(read);
        assertEquals(payment.getPaymentId(), read.getPaymentId());
        System.out.println(read);
    }

    @Test
    void update() {
        Payment updated = paymentService.update(new Payment.Builder()
                .copy(payment)
                .setPaymentStatus("Pending")
                .build());
        System.out.println("Updated: ");
        assertNotNull(updated);
        assertEquals("Pending", updated.getPaymentStatus());
        System.out.println(updated);
    }

    @Test
    void delete() {
        System.out.println("Deleted: ");
        Payment deleted = paymentService.delete(payment.getPaymentId());
        assertNotNull(deleted);
        System.out.println(deleted);
    }

    @Test
    void getAll() {
        System.out.println("All Payments: ");
        assertNotNull(paymentService.getAll());
        System.out.println(paymentService.getAll());
    }
}
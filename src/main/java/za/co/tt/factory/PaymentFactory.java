package za.co.tt.factory;

import za.co.tt.domain.Payment;
import za.co.tt.util.Helper;

import java.time.LocalDate;

public class PaymentFactory {

    public static Payment createPayment(String paymentMethod, String paymentStatus, double amount, LocalDate paymentDate) {
        if (Helper.isNullOrEmpty(paymentMethod) || Helper.isNullOrEmpty(paymentStatus) ||
                amount <= 0 || paymentDate == null || paymentDate.isAfter(LocalDate.now()) ) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentMethod(paymentMethod)
                .setPaymentStatus(paymentStatus)
                .setAmount(amount)
                .setPaymentDate(paymentDate)
                .build();
    }
}

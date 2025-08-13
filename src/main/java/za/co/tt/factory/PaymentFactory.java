/*Author: Bonke Bulana*/
package za.co.tt.factory;

import za.co.tt.domain.Order;
import za.co.tt.domain.Payment;
import za.co.tt.domain.User;
import za.co.tt.util.Helper;

import java.time.LocalDate;

public class PaymentFactory {

    public static Payment createPayment(long paymentId, String paymentMethod, String paymentStatus, double amount, LocalDate paymentDate, User user, Order order) {
        if (paymentId <= 0 || Helper.isNullOrEmpty(paymentMethod) || Helper.isNullOrEmpty(paymentStatus) ||
                amount <= 0 || paymentDate == null || paymentDate.isAfter(LocalDate.now()) || user == null || order == null) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setPaymentMethod(paymentMethod)
                .setPaymentStatus(paymentStatus)
                .setAmount(amount)
                .setPaymentDate(paymentDate)
                .setUser(user)
                .setOrder(order)
                .build();
    }
}
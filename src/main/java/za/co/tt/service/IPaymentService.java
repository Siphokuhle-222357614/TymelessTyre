/*Author: Bonke Bulana - 220539995*/
package za.co.tt.service;

import za.co.tt.domain.Payment;

import java.util.List;

public interface IPaymentService extends IService<Payment, Long> {

    Payment create(Payment payment);

    Payment read(Long paymentId);

    Payment update(Payment payment);

    Payment delete(Long paymentId);

    List<Payment> getAll();
}

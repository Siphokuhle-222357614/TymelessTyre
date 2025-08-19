/*Author: Bonke Bulana - 220539995*/
package za.co.tt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.tt.domain.Payment;
import za.co.tt.repository.PaymentRepository;
import za.co.tt.service.IPaymentService;

import java.util.List;
@Service
public class PaymentServiceImpl implements IPaymentService {
    private PaymentRepository repository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }
    @Override
    public Payment create(Payment payment) {
        return this.repository.save(payment);
    }

    @Override
    public Payment read(Long paymentId) {
        return this.repository.findById(paymentId).orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        if (this.repository.existsById(payment.getPaymentId()))
            return this.repository.save(payment);
        return null;
    }

    @Override
    public Payment delete(Long paymentId) {
        Payment payment = read(paymentId);
        if (payment != null) {
            this.repository.delete(payment);
            return payment;
        }
        return null;
    }

    @Override
    public List<Payment> getAll() {
        return this.repository.findAll();
    }
}

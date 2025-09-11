package za.co.tt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.tt.domain.Payment;
import za.co.tt.repository.PaymentRepository;
import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentRepository repository;

    @Override
    public Payment save(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Payment update(Payment payment) {
        if (repository.existsById(payment.getPaymentId())) {
            return repository.save(payment);
        }
        return null; // or throw exception
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Payment read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Payment> findAll() {
        return repository.findAll();
    }
}

package za.co.tt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.tt.domain.Cart;
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
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Entity with ID " + id + " not found");
        }

        repository.deleteById(id);
    } //made some changes to avoid having errors

    @Override
    public Payment read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Payment> findAll() {
        return repository.findAll();
    }

    // Additional methods specific to PaymentService
    public List<Payment> findPaymentsByUserId(Long userId) {
        return repository.findByUser_UserId(userId);
    }

    // Fixed parameter type to match repository method
    public Payment findPaymentByOrderId(Long orderId) {
        return repository.findByOrder_OrderId(orderId);
    }
}
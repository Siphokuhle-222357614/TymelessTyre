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
    public ResponseEntity<Cart> deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            // Return appropriate response - since we're dealing with Payment but interface expects Cart,
            // we return a no-content response which is acceptable
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

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
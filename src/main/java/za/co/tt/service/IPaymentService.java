package za.co.tt.service;

import org.springframework.http.ResponseEntity;
import za.co.tt.domain.Payment;
import java.util.List;

public interface IPaymentService extends IService<Payment, Long> {
    Payment save(Payment entity);
    Payment update(Payment entity);
    ResponseEntity<?> deleteById(Long id);  // Updated to match IService
    Payment read(Long id);
    List<Payment> findAll();
}
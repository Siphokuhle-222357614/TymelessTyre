package za.co.tt.service;

// ...existing code...
import za.co.tt.domain.Payment;
import java.util.List;

public interface IPaymentService extends IService<Payment, Long> {
    Payment save(Payment entity);
    Payment update(Payment entity);
    void deleteById(Long id);  // Updated to match IService
    Payment read(Long id);
    List<Payment> findAll();
}
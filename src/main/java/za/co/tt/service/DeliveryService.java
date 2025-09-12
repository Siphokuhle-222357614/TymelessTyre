package za.co.tt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.tt.domain.Delivery;
import za.co.tt.repository.DeliveryRepository;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService implements IService<Delivery, Long> {

    @Autowired
    private DeliveryRepository repository;

    @Override
    public Delivery save(Delivery delivery) {
        return repository.save(delivery);
    }

    @Override
    public Delivery update(Delivery delivery) {
        if (repository.existsById(delivery.getDeliveryId())) {
            return repository.save(delivery);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Delivery read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Delivery> findAll() {
        return repository.findAll();
    }

    public List<Delivery> findDeliveriesByStatus(String status) {
        return repository.findByDeliveryStatus(status);
    }

    public List<Delivery> findDeliveriesByCourier(String courierName) {
        return repository.findByCourierName(courierName);
    }

    public List<Delivery> findPendingDeliveries() {
        return repository.findByDeliveryStatus("Pending");
    }

    public List<Delivery> findCompletedDeliveries() {
        return repository.findByDeliveryStatus("Delivered");
    }
}

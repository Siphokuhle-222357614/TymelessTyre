package za.co.tt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.tt.domain.Delivery;
import za.co.tt.repository.DeliveryRepository;

import java.util.List;

@Service
public class DeliveryService implements IDeliveryService{

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public Delivery save(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery update(Delivery delivery) {
        if (deliveryRepository.existsById(delivery.getDeliveryId())) {
            return deliveryRepository.save(delivery);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        if (!deliveryRepository.existsById(id)) {
            throw new IllegalArgumentException("Entity with ID " + id + " not found");
        }

        deliveryRepository.deleteById(id);
    } //made some changes to avoid having errorseturn null;

    @Override
    public Delivery read(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }
} //Tried to clean this class, since it had errors. But you can make changes if you want to




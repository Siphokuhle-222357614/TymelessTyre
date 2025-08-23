package za.co.tt.service.delete;

import org.springframework.stereotype.Service;
import za.co.tt.domain.Rim;
import za.co.tt.repository.RimRepository;

import java.util.List;

@Service
public class RimService {

    private final RimRepository rimRepository;

    public RimService(RimRepository rimRepository) {
        this.rimRepository = rimRepository;
    }

    public List<Rim> getAllRims() {
        return rimRepository.findAll();
    }

    public Rim getRimById(Long id) {
        return rimRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rim not found with id: " + id));
    }

    public Rim createRim(Rim rim) {
        return rimRepository.save(rim);
    }

    public Rim updateRim(Long id, Rim rim) {
        Rim existingRim = getRimById(id);
        existingRim.setBrandName(rim.getBrandName());
        existingRim.setDiameter(rim.getDiameter());
        existingRim.setWidth(rim.getWidth());
        existingRim.setMaterial(rim.getMaterial());
        existingRim.setPrice(rim.getPrice());
        existingRim.setStockQuantity(rim.getStockQuantity());
        existingRim.setImageUrl(rim.getImageUrl());
        return rimRepository.save(existingRim);
    }

    public void deleteRim(Long id) {
        rimRepository.deleteById(id);
    }
}
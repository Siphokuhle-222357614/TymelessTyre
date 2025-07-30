package za.co.tt.service;

import org.springframework.stereotype.Service;
import za.co.tt.domain.Tyre;
import za.co.tt.repository.TyreRepository;

import java.util.List;

@Service
public class TyreService {

    private final TyreRepository tyreRepository;

    public TyreService(TyreRepository tyreRepository) {
        this.tyreRepository = tyreRepository;
    }

    public List<Tyre> getAllTyres() {
        return tyreRepository.findAll();
    }

    public Tyre getTyreById(Long id) {
        return tyreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tyre not found with id: " + id));
    }

    public Tyre createTyre(Tyre tyre) {
        return tyreRepository.save(tyre);
    }

    public Tyre updateTyre(Long id, Tyre tyre) {
        Tyre existingTyre = getTyreById(id);
        existingTyre.setBrandName(tyre.getBrandName());
        existingTyre.setTyreType(tyre.getTyreType());
        existingTyre.setAspectRatio(tyre.getAspectRatio());
        existingTyre.setWidth(tyre.getWidth());
        existingTyre.setWheelDiameter(tyre.getWheelDiameter());
        existingTyre.setMaxLoad(tyre.getMaxLoad());
        existingTyre.setSpeedRating(tyre.getSpeedRating());
        existingTyre.setTyrePressure(tyre.getTyrePressure());
        existingTyre.setTyreCode(tyre.getTyreCode());
        existingTyre.setEoMark(tyre.getEoMark());
        existingTyre.setDescription(tyre.getDescription());
        existingTyre.setPrice(tyre.getPrice());
        existingTyre.setStockQuantity(tyre.getStockQuantity());
        existingTyre.setImageUrl(tyre.getImageUrl());
        return tyreRepository.save(existingTyre);
    }

    public void deleteTyre(Long id) {
        tyreRepository.deleteById(id);
    }
}
package za.co.tt.service.impl;

import org.springframework.stereotype.Service;
import za.co.tt.domain.Rim;
import za.co.tt.repository.RimRepository;
import za.co.tt.service.IRimService;

import java.util.List;

@Service
public class RimServiceImpl implements IRimService {

    private final RimRepository rimRepository;

    public RimServiceImpl(RimRepository rimRepository) {
        this.rimRepository = rimRepository;
    }

    @Override
    public List<Rim> getAllRims() {
        return rimRepository.findAll();
    }

    @Override
    public Rim getRimById(Long id) {
        return rimRepository.findById(id).orElse(null);
    }

    @Override
    public Rim createRim(Rim rim) {
        return rimRepository.save(rim);
    }

    @Override
    public Rim updateRim(Long id, Rim rim) {
       // rim.setId(id);
        return rimRepository.save(rim);
    }

    @Override
    public void deleteRim(Long id) {
        rimRepository.deleteById(id);
    }
}
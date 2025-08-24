package za.co.tt.service.impl;

import org.springframework.stereotype.Service;
import za.co.tt.domain.Tyre;
import za.co.tt.repository.ITyreRepository;
import za.co.tt.service.ITyreService;

import java.util.List;

@Service
public class TyreServiceImpl implements ITyreService {

    private final ITyreRepository tyreRepository;

    public TyreServiceImpl(ITyreRepository tyreRepository) {
        this.tyreRepository = tyreRepository;
    }

    @Override
    public List<Tyre> getAllTyres() {
        return tyreRepository.findAll();
    }

    @Override
    public Tyre getTyreById(Long id) {
        return tyreRepository.findById(id).orElse(null);
    }

    @Override
    public Tyre createTyre(Tyre tyre) {
        return tyreRepository.save(tyre);
    }

    @Override
    public Tyre updateTyre(Long id, Tyre tyre) {
       // tyre.setId(id);
        return tyreRepository.save(tyre);
    }

    @Override
    public void deleteTyre(Long id) {
        tyreRepository.deleteById(id);
    }
}
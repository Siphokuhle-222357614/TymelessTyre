package za.co.tt.service;

import za.co.tt.domain.Tyre;
import java.util.List;

public interface ITyreService {
    List<Tyre> getAllTyres();
    Tyre getTyreById(Long id);
    Tyre createTyre(Tyre tyre);
    Tyre updateTyre(Long id, Tyre tyre);
    void deleteTyre(Long id);
}
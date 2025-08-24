package za.co.tt.service;

import za.co.tt.domain.Rim;
import java.util.List;

public interface IRimService {
    List<Rim> getAllRims();
    Rim getRimById(Long id);
    Rim createRim(Rim rim);
    Rim updateRim(Long id, Rim rim);
    void deleteRim(Long id);
}
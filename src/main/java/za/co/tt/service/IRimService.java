package za.co.tt.service;

import za.co.tt.domain.Rim;

public interface IRimService extends IService<Rim, Long> {

    Rim create(Rim rim);

    Rim read(Long rimId);

    Rim update(Rim rim);

    Rim delete(Long rimId);
}

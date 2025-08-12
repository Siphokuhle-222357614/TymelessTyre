package za.co.tt.service;

import za.co.tt.domain.Tyre;

public interface ITyreService extends IService<Tyre, Long> {

    Tyre create(Tyre tyre);

    Tyre read(Long tyreId);

    Tyre update(Tyre tyre);

    Tyre delete(Long tyreId);

}

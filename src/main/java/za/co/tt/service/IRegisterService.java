package za.co.tt.service;

import za.co.tt.domain.Register;

import java.util.List;

public interface IRegisterService extends IService<Register, Long> {

    Register create(Register register);

    Register read(Long registerId);

    Register update(Register register);

    Register delete(Long registerId);

    List<Register> getAll();
}

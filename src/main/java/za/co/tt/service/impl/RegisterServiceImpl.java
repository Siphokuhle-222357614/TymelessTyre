package za.co.tt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.tt.domain.Register;
import za.co.tt.repository.PaymentRepository;
import za.co.tt.repository.RegisterRepository;
import za.co.tt.service.IRegisterService;

import java.util.List;
@Service
public class RegisterServiceImpl implements IRegisterService {
    private RegisterRepository repository;

    @Autowired
    public RegisterServiceImpl(RegisterRepository repository) {
        this.repository = repository;
    }


    @Override
    public Register create(Register register) {
        return repository.save(register);
    }

    @Override
    public Register read(Long userId) {
        return this.repository.findById(userId).orElse(null);
    }

    @Override
    public Register update(Register register) {
        if (this.repository.existsById(register.getUserId()))
            return this.repository.save(register);
        return null;
    }

    @Override
    public Register delete(Long userId) {
        Register register = read(userId);
        if (register != null) {
            this.repository.delete(register);
            return register;
        }
        return null;
    }

    @Override
    public List<Register> getAll() {
        return this.repository.findAll();
    }
}

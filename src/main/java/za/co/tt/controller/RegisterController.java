/*Author: Bonke Bulana - 220539995*/
package za.co.tt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.tt.domain.Register;
import za.co.tt.service.impl.RegisterServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterServiceImpl registerService;

    @PostMapping("/create")
    public Register create(@RequestBody Register register) {
        return registerService.create(register);
    }

    @GetMapping("/read/{id}")
    public Register read(@PathVariable Long id) {
        return registerService.read(id);
    }

    @PostMapping("/update")
    public Register update(@RequestBody Register register) {
        return registerService.update(register);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        registerService.delete(id);
        return true;
    }

    @GetMapping("/getAll")
    public List<Register> getAll() {
        return registerService.getAll();
    }
}


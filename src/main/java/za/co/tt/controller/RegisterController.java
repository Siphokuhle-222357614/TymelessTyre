/*Author: Bonke Bulana - 220539995*/
package za.co.tt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import za.co.tt.domain.Register;
import za.co.tt.service.impl.RegisterServiceImpl;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
//@CrossOrigin(origins = "*")
@RequestMapping("api/register")
public class RegisterController {

    @Autowired
    private RegisterServiceImpl registerService;

    @PostMapping("api/create")
    public Register create(@RequestBody Register register) {
        return registerService.create(register);
    }

    @GetMapping("api/read/{id}")
    public Register read(@PathVariable Long id) {
        return registerService.read(id);
    }

    @PostMapping("api/update")
    public Register update(@RequestBody Register register) {
        return registerService.update(register);
    }

    @DeleteMapping("api/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        registerService.delete(id);
        return true;
    }

    @GetMapping("api/getAll")
    public List<Register> getAll() {
        return registerService.getAll();
    }
}


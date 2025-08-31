/*
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */
package za.co.tt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import za.co.tt.domain.User;
import za.co.tt.service.impl.UserServiceImpl;
import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/user")
public class UserController {

    private UserServiceImpl service;

    @Autowired
    UserController(UserServiceImpl service) {
        this.service = service;
    }

    @PostMapping("api/create")
    public User create(@RequestBody User user) {
        return service.save(user);
    }

    @GetMapping("api/read/{id}")
    public User read(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping("api/update")
    public User update(@RequestBody User user) {
        return service.update(user.getUserId(), user);
    }

    @DeleteMapping("api/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        service.deleteById(id);
        return true;
    }

    @GetMapping("api/getAll")
    public List<User> getAll() {
        return service.findAll();
    }
}




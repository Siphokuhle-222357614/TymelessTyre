package za.co.tt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tt.domain.User;
import za.co.tt.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/read/{id}")
    public User readUser(@PathVariable Long id){
        return userService.read(id);
    }

    @PostMapping("/update")
    public User updateUser(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

}

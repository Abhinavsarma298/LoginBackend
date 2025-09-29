package com.siritech.Login.Controller;

import com.siritech.Login.Entity.UserEntity;
import com.siritech.Login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public UserEntity create(@RequestBody UserEntity user)
    {
        return service.register(user);

    }

    @GetMapping("/show/{id}")
    public Optional<UserEntity> show(@PathVariable int id)
    {
        return service.show(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody UserEntity user)
    {
        return service.update(user.getEmail(),user.getPassword());
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@RequestParam int id)
    {
        return service.delete(id);
    }
}

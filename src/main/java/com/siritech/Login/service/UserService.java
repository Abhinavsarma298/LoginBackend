package com.siritech.Login.service;

import com.siritech.Login.Entity.UserEntity;
import com.siritech.Login.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public UserEntity register(UserEntity user) {
        return repo.save(user);
    }

    public Optional<UserEntity> show(int id) {

        return repo.findById(id);
    }

    public String update(String email, String password) {

        UserEntity exists = repo.getByEmail(email);

        if(exists == null)
        {
            return "E-Mail Not Found";
        }
        else {
            exists.setPassword(password);
            repo.save(exists);

            return "Registration Successfull";
        }

    }

    public String delete(int id) {

        Optional <UserEntity> exists = repo.findById(id);
        if(exists.isEmpty())
        {
            return "User Not Found";
        }
        repo.deleteById(id);
        return "Delete Successfull";
    }
}

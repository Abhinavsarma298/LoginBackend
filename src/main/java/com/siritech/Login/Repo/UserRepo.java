package com.siritech.Login.Repo;

import com.siritech.Login.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {

    UserEntity getByEmail(String email);
}

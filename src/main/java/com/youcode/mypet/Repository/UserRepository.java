package com.youcode.mypet.Repository;

import com.youcode.mypet.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // customQueryJoins between all tables to find email
    UserEntity findByEmail(String email);
}
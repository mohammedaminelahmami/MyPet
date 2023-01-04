package com.youcode.mypet.Service;

import com.youcode.mypet.Entity.UserEntity;
import com.youcode.mypet.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findUser(String email)
    {
        UserEntity user = userRepository.findByEmail(email);

        // check password

        if(user != null) {
            System.out.println("l9a l user");
            return new User(user.getUsername(), user.getHashed_password(), new ArrayList<>());
        }else{
            throw  new UsernameNotFoundException(email);
        }
    }
}

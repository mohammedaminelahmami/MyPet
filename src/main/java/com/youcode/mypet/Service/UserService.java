package com.youcode.mypet.Service;

import com.youcode.mypet.DTO.AnimalDTO;
import com.youcode.mypet.DTO.mapper.IMapperDto;
import com.youcode.mypet.Entity.AnimalEntity;
import com.youcode.mypet.Entity.UserEntity;
import com.youcode.mypet.Repository.UserRepository;
import com.youcode.mypet.Request.RegisterRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findUser(String email)
    {
        UserEntity user = userRepository.findByEmail(email);

        // check password
        if(user != null) {
            return new User(user.getEmail(), user.getHashed_password(), new ArrayList<>());
        }else{
            throw new UsernameNotFoundException(email);
        }
    }

    public void saveUser(RegisterRequest registerRequest) throws Exception
    {
        UserEntity userEntity = userRepository.findByEmail(registerRequest.getEmail());

        if(userEntity == null) {
            UserEntity user = new UserEntity();
            BeanUtils.copyProperties(registerRequest, user);
            user.setHashed_password(bCryptPasswordEncoder.encode(registerRequest.getPassword()));
            userRepository.save(user);
        }else{
            throw new Exception("user already exist");
        }
    }

    public int findUserIdByEmail(String email) {
        return userRepository.findByEmail(email).getId_user();
    }
}
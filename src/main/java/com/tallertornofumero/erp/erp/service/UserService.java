package com.tallertornofumero.erp.erp.service;

import com.tallertornofumero.erp.erp.exception.UsernameAlreadyExistsException;
import com.tallertornofumero.erp.erp.exception.UsernameNotExistsException;
import com.tallertornofumero.erp.erp.model.User;
import com.tallertornofumero.erp.erp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        boolean exists = userRepository.existsByUserName(user.getUserName());
        if(exists){
            throw new UsernameAlreadyExistsException(user.getUserName());
        }
        return userRepository.save(user);
    }

    public User updateUser(String userName, User user){
        User userDB = userRepository.findByUserName(userName);

        if(userDB == null){
            throw new UsernameNotExistsException(user.getUserName());
        }

        userDB.setUserName(user.getUserName());
        userDB.setRol(user.getRol());
        userDB.setEmail(user.getEmail());
        userDB.setStatus(user.getStatus());
        userDB.setPassword(user.getPassword());

        return userRepository.save(userDB);
    }


}

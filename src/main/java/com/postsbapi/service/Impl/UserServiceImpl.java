package com.postsbapi.service.Impl;

import com.postsbapi.model.User;
import com.postsbapi.repository.UserRepository;
import com.postsbapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    public User checkLogin(String username, String password){
        return userRepository.findByUsernameAndPasswords(username,password);
    }
}

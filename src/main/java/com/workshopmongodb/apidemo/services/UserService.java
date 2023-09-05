package com.workshopmongodb.apidemo.services;

import com.workshopmongodb.apidemo.entity.User;
import com.workshopmongodb.apidemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }
}

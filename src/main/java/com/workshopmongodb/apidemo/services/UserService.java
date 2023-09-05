package com.workshopmongodb.apidemo.services;


import com.workshopmongodb.apidemo.entity.User;
import com.workshopmongodb.apidemo.repository.UserRepository;
import com.workshopmongodb.apidemo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ObjectNotFoundException("User " + id + " not found");
        }
        return user;
    }
}

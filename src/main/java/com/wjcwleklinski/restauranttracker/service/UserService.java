package com.wjcwleklinski.restauranttracker.service;

import com.wjcwleklinski.restauranttracker.entity.User;
import com.wjcwleklinski.restauranttracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByUserName(String name) {
        return userRepository.findByUsername(name);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public void saveNewUser(User user) {
        userRepository.save(user);
    }

    public boolean passwordsMatch(String password1, String password2) {
        return password1.equals(password2);
    }
}

package com.wjcwleklinski.restauranttracker.service;

import com.wjcwleklinski.restauranttracker.entity.Role;
import com.wjcwleklinski.restauranttracker.entity.User;
import com.wjcwleklinski.restauranttracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleService roleService;

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

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);

        Role role = roleService.findByName("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(role)));
        userRepository.save(user);

    }

    public boolean passwordsMatch(String password1, String password2) {
        return password1.equals(password2);
    }
}

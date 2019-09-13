package com.wjcwleklinski.restauranttracker.service;

import com.wjcwleklinski.restauranttracker.entity.Role;
import com.wjcwleklinski.restauranttracker.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}

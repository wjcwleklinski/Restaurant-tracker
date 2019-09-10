package com.wjcwleklinski.restauranttracker.repository;

import com.wjcwleklinski.restauranttracker.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    // test this
    User findByEmail(String email);

    User findByUsername(String name);
}

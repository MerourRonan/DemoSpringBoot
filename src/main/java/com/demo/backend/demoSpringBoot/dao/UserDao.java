package com.demo.backend.demoSpringBoot.dao;

import com.demo.backend.demoSpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Integer> {

    User findByName(String name);
}

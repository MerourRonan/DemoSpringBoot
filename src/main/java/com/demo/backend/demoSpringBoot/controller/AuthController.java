package com.demo.backend.demoSpringBoot.controller;

import com.demo.backend.demoSpringBoot.dao.UserDao;
import com.demo.backend.demoSpringBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/api/auth")
    public ResponseEntity<User> authenticate(@RequestBody User user)
    {
        System.out.println("user input = " + user);
        System.out.print("\u001B[34m "+"AuthController : authenticate : "+"user" + "\n "+"\u001B[0m");
        User userAuth = userDao.findByName(user.getName());
        if(userAuth == null)
        {
            System.out.println("error = " + userAuth);
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("OK = "+userAuth);
        return new ResponseEntity<User>(userAuth,HttpStatus.OK);
    }
}

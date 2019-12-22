package com.norbertcseh.ticketing.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.norbertcseh.ticketing.Entities.User;
import com.norbertcseh.ticketing.Repositories.UserRepository;
import com.norbertcseh.ticketing.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * UserController
 */
@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public void postMethodName(@RequestBody User user) {
        userService.register(user);
    }

}
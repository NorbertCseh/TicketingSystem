package com.norbertcseh.ticketing.Controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import com.norbertcseh.ticketing.Entities.User;
import com.norbertcseh.ticketing.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * UserController
 */
@RestController
@CrossOrigin
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/user/all")
    public ArrayList<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/api/user/{id}")
    public User getSingleUser(@PathVariable Long id) {
        return userService.getSingleUser(id);
    }

    @PutMapping("/api/user/{id}")
    public User updateSingleUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    // @Secured({ "ROLE_ADMIN" })
    @DeleteMapping("/api/user/{id}")
    public void deleteSingleUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping(value = "/api/user/register")
    public void postMethodName(@RequestBody User user) {
        userService.register(user);
    }

}
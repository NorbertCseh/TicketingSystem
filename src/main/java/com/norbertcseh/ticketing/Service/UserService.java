package com.norbertcseh.ticketing.Service;

import java.util.ArrayList;
import java.util.Optional;

import com.norbertcseh.ticketing.Entities.User;
import com.norbertcseh.ticketing.Repositories.UserRepository;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.bytebuddy.implementation.bytecode.Throw;

/**
 * UserService
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    public User register(User user) {
        System.out.println(user.toString());

        String secret = "{bcrypt}" + encoder.encode(user.getPassword());
        user.setPassword(secret);

        // TODO assign a role to this user
        // user.addRole(roleService.findByName("ROLE_USER"));

        save(user);

        return user;
    }

    public User updateUser(Long id, User updatedUser) {
        // TODO IT is not working correctly, it creates a new user
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.save(updatedUser);
            user = userRepository.findById(id);
            return user.get();
        } else {
            return null;
        }
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public ArrayList<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getSingleUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
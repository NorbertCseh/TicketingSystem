package com.norbertcseh.ticketing.Service;

import com.norbertcseh.ticketing.Entities.User;
import com.norbertcseh.ticketing.Repositories.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
        // take the password from the form and encode
        System.out.println(user.toString());

        String secret = "{bcrypt}" + encoder.encode(user.getPassword());
        user.setPassword(secret);

        // assign a role to this user
        // user.addRole(roleService.findByName("ROLE_USER"));

        // save user
        save(user);

        // return the user
        return user;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

}
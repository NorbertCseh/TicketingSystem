package com.norbertcseh.ticketing;

import java.util.HashSet;
import java.util.Set;

import com.norbertcseh.ticketing.Entities.Profile;
import com.norbertcseh.ticketing.Entities.Role;
import com.norbertcseh.ticketing.Entities.User;
import com.norbertcseh.ticketing.Repositories.ProfileRepository;
import com.norbertcseh.ticketing.Repositories.RoleRepository;
import com.norbertcseh.ticketing.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class CommandLineAppStartupRunner implements CommandLineRunner {

    RoleRepository roleRepository;
    ProfileRepository profileRepository;
    UserRepository userRepository;

    @Autowired
    public CommandLineAppStartupRunner(RoleRepository roleRepository, ProfileRepository profileRepository,
            UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role role = new Role("Admin");
        roleRepository.save(role);
        Set<Role> roles = new HashSet<Role>();
        roles.add(role);

        Profile profile = new Profile("Norbert Cseh", "NorbertCseh", "Company", "Position");
        profileRepository.save(profile);

        User user = new User("email@gmail.com", "pass123123123", true);
        user.setProfile(profile);
        user.setRoles(roles);
        userRepository.save(user);
    }

}
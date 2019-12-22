package com.norbertcseh.ticketing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.norbertcseh.ticketing.Entities.Comment;
import com.norbertcseh.ticketing.Entities.Profile;
import com.norbertcseh.ticketing.Entities.Project;
import com.norbertcseh.ticketing.Entities.Role;
import com.norbertcseh.ticketing.Entities.Ticket;
import com.norbertcseh.ticketing.Entities.User;
import com.norbertcseh.ticketing.Repositories.CommentRepository;
import com.norbertcseh.ticketing.Repositories.ProfileRepository;
import com.norbertcseh.ticketing.Repositories.ProjectRepository;
import com.norbertcseh.ticketing.Repositories.RoleRepository;
import com.norbertcseh.ticketing.Repositories.TicketRepository;
import com.norbertcseh.ticketing.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    RoleRepository roleRepository;
    ProfileRepository profileRepository;
    UserRepository userRepository;
    TicketRepository ticketRepository;
    ProjectRepository projectRepository;
    CommentRepository commentRepository;

    @Autowired
    public CommandLineAppStartupRunner(RoleRepository roleRepository, ProfileRepository profileRepository,
            UserRepository userRepository, TicketRepository ticketRepository, ProjectRepository projectRepository,
            CommentRepository commentRepository) {
        this.roleRepository = roleRepository;
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.projectRepository = projectRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Project project = new Project("OTP");
        Role role = new Role("Admin");
        roleRepository.save(role);
        Set<Role> roles = new HashSet<Role>();
        roles.add(role);

        Profile profile = new Profile("Norbert Cseh", "NorbertCseh", "Company", "Position");
        profileRepository.save(profile);

        User user = new User("email@gmail.com", "pass123123123", project, true);
        user.setProfile(profile);
        user.setRoles(roles);
        List<User> users = new ArrayList<User>();
        users.add(user);
        userRepository.save(user);

        project.setUsers(users);
        projectRepository.save(project);

        Ticket ticket = new Ticket(project, "Support request", "Minor", "Urgent", "QA", "Please fix everything",
                "Everything is useless here atm.");
        ticket.setAssignedUser(user);
        ticketRepository.save(ticket);

        user = userRepository.findByEmail("email@gmail.com");
        user.setProject(project);
        userRepository.save(user);

        List<Ticket> tickets = new ArrayList<Ticket>();
        tickets.add(ticket);
        project.setTickets(tickets);
        projectRepository.save(project);

        Comment comment = new Comment("This is a comment komrades", ticket);
        commentRepository.save(comment);
        List<Comment> comments = new ArrayList<Comment>();
        comments.add(comment);
        ticket.setComments(comments);
        ticketRepository.save(ticket);

        user.setAssignedTickets(tickets);
        userRepository.save(user);

    }

}
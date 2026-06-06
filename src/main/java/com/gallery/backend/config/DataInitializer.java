package com.gallery.backend.config;

import com.gallery.backend.model.User;
import com.gallery.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User admin = new User();
        admin.setEmail("harishkumawat@gallery.com");
        admin.setPassword(passwordEncoder.encode("Kumawat@2611"));
        admin.setRole("ADMIN");
        userRepository.save(admin);
        System.out.println("==================================");
        System.out.println("Admin user created!");
        System.out.println("Email: harishkumawat@gallery.com");
        System.out.println("Password: Kumawat@2611");
        System.out.println("==================================");
    }
}

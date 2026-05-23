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
        admin.setEmail("admin@gallery.com");
        admin.setPassword(passwordEncoder.encode("Admin@123"));
        admin.setRole("ADMIN");
        userRepository.save(admin);
        System.out.println("==================================");
        System.out.println("Admin user created!");
        System.out.println("Email: admin@gallery.com");
        System.out.println("Password: Admin@123");
        System.out.println("==================================");
    }
}

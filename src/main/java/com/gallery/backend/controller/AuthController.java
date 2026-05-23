package com.gallery.backend.controller;

import com.gallery.backend.dto.AuthRequest;
import com.gallery.backend.dto.AuthResponse;
import com.gallery.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register-admin")
    public ResponseEntity<String> registerAdmin(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(
                authService.registerAdmin(request.getEmail(), request.getPassword()));
    }
}
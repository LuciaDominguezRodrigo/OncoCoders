package org.example.oncocoderswebapp.controller.auth;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.example.oncocoderswebapp.DTO.FullUserDTO;
import org.example.oncocoderswebapp.DTO.UserLoginDTO;
import org.example.oncocoderswebapp.DTO.UserRegisterDTO;
import org.example.oncocoderswebapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<FullUserDTO> login(@RequestBody UserLoginDTO loginDTO) {
        Optional<FullUserDTO> user = authService.authenticate(loginDTO);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(401).build());
    }


    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody UserRegisterDTO registerDTO) {
        if (authService.isEmailTaken(registerDTO.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", "El correo ya está en uso"));
        }
        boolean registered = authService.registerUser(registerDTO);
        if (!registered) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Error al registrar usuario"));
        }
        return ResponseEntity.ok(Collections.singletonMap("message", "Usuario registrado exitosamente"));
    }

}


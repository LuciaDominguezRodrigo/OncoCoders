package org.example.oncocoderswebapp.controller;

import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/role")
    public ResponseEntity<Map<String, String>> getUserRole(@RequestHeader("Authorization") String token) {
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", "Token no proporcionado"));
        }

        Optional<User> userOptional = tokenService.getUserFromToken(token.replace("Bearer ", ""));

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok(Collections.singletonMap("role", user.getRole()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("error", "Token inválido o usuario no encontrado"));
        }
    }
}

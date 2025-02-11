package org.example.oncocoderswebapp.controller;

import org.example.oncocoderswebapp.DTO.FormDTO;
import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.model.UserFormResponse;
import org.example.oncocoderswebapp.repository.UserFormRepository;
import org.example.oncocoderswebapp.service.TokenService;
import org.example.oncocoderswebapp.service.UserFormService;
import org.example.oncocoderswebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/form")
public class UserFormController {

    @Autowired
    private UserFormService userFormService;

    @Autowired
    private TokenService tokenService;



    @PreAuthorize("hasRole('USER')")
    @PostMapping("/formResponse")

    public ResponseEntity<String> enviarFormulario(@RequestBody Map<String, String> respuestasFormulario, @RequestHeader("Authorization") String token) {
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", "Token no proporcionado").toString());
        }

        User user = null;

        Optional<User> userOptional = tokenService.getUserFromToken(token.replace("Bearer ", ""));

        if (userOptional.isPresent()) {
            user = userOptional.get();
        }
        else {
            return ResponseEntity.status(401).body(Collections.singletonMap("error", "Usuario no autentificado").toString());

        }

        userFormService.save(user, respuestasFormulario);
        return ResponseEntity.ok("Formulario creado satisfactoriamente!");
    }
}



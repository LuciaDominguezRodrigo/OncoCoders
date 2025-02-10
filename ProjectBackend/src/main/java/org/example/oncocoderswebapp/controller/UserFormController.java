package org.example.oncocoderswebapp.controller;

import org.example.oncocoderswebapp.DTO.FormDTO;
import org.example.oncocoderswebapp.model.User;
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

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/form")
public class UserFormController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserFormService userFormService;

    @Autowired
    private TokenService tokenService;



    @PreAuthorize("hasRole('USER')")
    @PostMapping("/formResponse")
    public ResponseEntity<String> enviarFormulario(@RequestBody FormDTO formularioDTO, @RequestHeader("Authorization") String token) {
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", "Token no proporcionado").toString());
        }

        User user = null;

        Optional<User> userOptional = tokenService.getUserFromToken(token.replace("Bearer ", ""));

        if (userOptional.isPresent()) {
            user = userOptional.get();
        }

        userFormService.save(user, formularioDTO.getPregunta1(), formularioDTO.getPregunta2(), formularioDTO.getPregunta3());
        return ResponseEntity.ok("Formulario creado satisfactoriame!");
    }
    }



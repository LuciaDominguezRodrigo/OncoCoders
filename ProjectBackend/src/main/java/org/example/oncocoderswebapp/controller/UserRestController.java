package org.example.oncocoderswebapp.controller;

import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
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

    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> getUserProfile(@RequestHeader("Authorization") String token) {
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Token no proporcionado"));
        }

        // Eliminar el prefijo "Bearer " del token
        String jwtToken = token.replace("Bearer ", "");

        // Obtener el usuario a partir del token
        Optional<User> userOptional = tokenService.getUserFromToken(jwtToken);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Crear el mapa con la información del usuario
            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("name", user.getName());
            userInfo.put("hospital", user.getHospitalReferencia());
            userInfo.put("zone", user.getComunidadAutonoma());
            userInfo.put("doctor", user.getMedicUser() != null ? user.getMedicUser().getName() : "Sin médico asignado");

            // Retornar la respuesta con el perfil del usuario
            return ResponseEntity.ok(userInfo);
        } else {
            // Si no se encuentra el usuario o el token es inválido
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Token inválido o usuario no encontrado"));
        }
    }


}

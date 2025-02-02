package org.example.oncocoderswebapp.controller.auth;

import java.util.*;

import org.example.oncocoderswebapp.DTO.FullUserDTO;
import org.example.oncocoderswebapp.DTO.UserLoginDTO;
import org.example.oncocoderswebapp.DTO.UserRegisterDTO;
import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.service.AuthService;
import org.example.oncocoderswebapp.service.TokenService;
import org.example.oncocoderswebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO loginDTO) {
        Optional<Map<String, Object>> authResult = authService.authenticate(loginDTO);

        if (authResult.isPresent()) {
            return ResponseEntity.ok(authResult.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("error", "Credenciales inválidas"));
        }
    }


    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody UserRegisterDTO registerDTO) {
        if (authService.isEmailTaken(registerDTO.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", "El correo ya está en uso"));
        }

        User newUser = authService.registerUser(registerDTO);

        if (newUser == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Error al registrar usuario"));
        }

        String token = tokenService.generateToken(newUser);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Usuario registrado exitosamente");
        response.put("role", newUser.getRole());
        response.put("token", token);
        response.put("medicoAsignado", newUser.getMedicUser() != null ? new FullUserDTO(newUser.getMedicUser()) : null);

        return ResponseEntity.ok(response);
    }



    @GetMapping("/available-doctors")
    public ResponseEntity<List<FullUserDTO>> getAvailableDoctors(
            @RequestParam String comunidadAutonoma,
            @RequestParam String hospitalReferencia) {

        List<User> doctors = userService.findAvailableDoctors(comunidadAutonoma, hospitalReferencia);
        List<FullUserDTO> doctorDTOs = doctors.stream().map(FullUserDTO::new).toList();

        return ResponseEntity.ok(doctorDTOs);
    }
}



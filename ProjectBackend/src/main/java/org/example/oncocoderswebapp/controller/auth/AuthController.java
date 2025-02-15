package org.example.oncocoderswebapp.controller.auth;

import java.util.*;

import org.example.oncocoderswebapp.DTO.FullUserDTO;
import org.example.oncocoderswebapp.DTO.UserLoginDTO;
import org.example.oncocoderswebapp.DTO.UserRegisterDTO;
import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.security.jwt.JwtTokenProvider;
import org.example.oncocoderswebapp.security.jwt.Token;
import org.example.oncocoderswebapp.security.jwt.UserLoginService;
import org.example.oncocoderswebapp.service.AuthService;
import org.example.oncocoderswebapp.service.TokenService;
import org.example.oncocoderswebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO loginDTO) {
        // Autenticar al usuario utilizando el servicio
        Optional<Map<String, Object>> authResult = authService.authenticate(loginDTO);

        if (authResult.isPresent()) {
            Map<String, Object> response = authResult.get();
            String token = (String) response.get("token");

            UserDetails user = (UserDetails) response.get("user");

            // Generamos los nuevos tokens
            Token newAccessToken = jwtTokenProvider.generateToken(user);
            Token newRefreshToken = jwtTokenProvider.generateRefreshToken(user);

            // Creamos las cabeceras para agregar las cookies
            HttpHeaders responseHeaders = new HttpHeaders();
            userLoginService.addAccessTokenCookie(responseHeaders, newAccessToken);  // Usamos UserLoginService
            userLoginService.addRefreshTokenCookie(responseHeaders, newRefreshToken);  // Usamos UserLoginService

            // Devolvemos la respuesta con los tokens en las cookies
            return ResponseEntity.ok().headers(responseHeaders).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("error", "Credenciales inválidas"));
        }
    }




    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody UserRegisterDTO registerDTO) {
        if (!registerDTO.isConsentFirm()) { // Verificamos si se firmó el consentimiento
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", "Debe firmar el consentimiento para registrarse"));
        }

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

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(@RequestHeader("Authorization") String token) {
        // Verificar si el token está presente y no es vacío
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", "Token no proporcionado"));
        }

        // Eliminar el prefijo "Bearer " del token si está presente
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);  // Elimina el prefijo "Bearer "
        }

        // Invalidar el token
        boolean isLoggedOut = tokenService.invalidateToken(token);

        // Responder dependiendo de si la invalidación fue exitosa
        if (isLoggedOut) {
            return ResponseEntity.ok(Collections.singletonMap("message", "Logout exitoso"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("error", "Token inválido o ya expirado"));
        }
    }



}



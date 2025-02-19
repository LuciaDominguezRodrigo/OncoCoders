package org.example.oncocoderswebapp.controller;

import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.service.TokenService;
import org.example.oncocoderswebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    @Autowired
    private UserService userService;

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
            userInfo.put("doctorHospital", user.getMedicUser() != null ? user.getMedicUser().getHospitalReferencia() : "Sin médico asignado");
            userInfo.put("doctorZone", user.getMedicUser() != null ? user.getMedicUser().getComunidadAutonoma() : "Sin médico asignado");

            userInfo.put("role", user.getRole());
            // Retornar la respuesta con el perfil del usuario
            return ResponseEntity.ok(userInfo);
        } else {
            // Si no se encuentra el usuario o el token es inválido
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Token inválido o usuario no encontrado"));
        }
    }

    @PutMapping("/profile/name")
    public ResponseEntity<Map<String, String>> updateUserName(@RequestHeader("Authorization") String token,
                                                              @RequestBody Map<String, String> body) {
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", "Token no proporcionado"));
        }

        String jwtToken = token.replace("Bearer ", "");

        Optional<User> userOptional = tokenService.getUserFromToken(jwtToken);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            String newName = body.get("newName");

            if (newName == null || newName.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Collections.singletonMap("error", "El parámetro 'newName' es obligatorio"));
            }

            user.setName(newName);
            userService.updateUser(user);

            return ResponseEntity.ok(Collections.singletonMap("message", "Nombre actualizado correctamente"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("error", "Token inválido o usuario no encontrado"));
        }
    }
    @PutMapping("/profile/hospital")
    public ResponseEntity<Map<String, Object>> updateUserHospital(@RequestHeader("Authorization") String token,
                                                                  @RequestBody Map<String, String> body) {
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", "Token no proporcionado"));
        }

        String jwtToken = token.replace("Bearer ", "");

        Optional<User> userOptional = tokenService.getUserFromToken(jwtToken);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            String newHospital = body.get("newHospital");

            if (newHospital == null || newHospital.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Collections.singletonMap("error", "El parámetro 'newHospital' es obligatorio"));
            }

            // Cambiar hospital
            user.setHospitalReferencia(newHospital);

            // Asignar un nuevo médico si el hospital cambió
            userService.asignarPacienteAMedico(user);

            // Actualizar el usuario con el nuevo hospital
            userService.updateUser(user);

            // Recuperar el usuario actualizado
            Optional<User> updatedUser = userService.findById(user.getId());

            return ResponseEntity.ok(Collections.singletonMap("user", updatedUser));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("error", "Token inválido o usuario no encontrado"));
        }
    }


    @PutMapping("/profile/zone")
    public ResponseEntity<Map<String, String>> updateUserZone(@RequestHeader("Authorization") String token,
                                                              @RequestBody Map<String, String> body) {
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", "Token no proporcionado"));
        }

        String jwtToken = token.replace("Bearer ", "");

        Optional<User> userOptional = tokenService.getUserFromToken(jwtToken);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            String newZone = body.get("newZone");

            if (newZone == null || newZone.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Collections.singletonMap("error", "El parámetro 'newZone' es obligatorio"));
            }

            // Cambiar zona
            user.setComunidadAutonoma(newZone);

            // Asignar un nuevo médico de la zona
            userService.asignarPacienteAMedico(user);

            userService.updateUser(user);

            return ResponseEntity.ok(Collections.singletonMap("message", "Zona actualizada correctamente"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("error", "Token inválido o usuario no encontrado"));
        }
    }

    @PreAuthorize("hasRole('MEDICUSER')")
    @GetMapping("/patients")
    public ResponseEntity<List<User>> getPatients(@RequestHeader("Authorization") String token) {
        Optional<User> userOptional = tokenService.getUserFromToken(token.replace("Bearer ", ""));

        if (userOptional.isEmpty()) {
            return ResponseEntity.ofNullable(null);
        }
        String email = userOptional.get().getEmail();
        List<User> patients = userService.getPacientesByMedic(email);
        return ResponseEntity.ok(patients);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/ban/{id}")
    public ResponseEntity<Map<String, String>> banUser(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setBanned(true);
            userService.updateUser(user);
            return ResponseEntity.ok(Collections.singletonMap("message", "Usuario baneado correctamente"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", "Usuario no encontrado"));
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/unban/{id}")
    public ResponseEntity<Map<String, String>> unbanUser(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setBanned(false);
            userService.updateUser(user);
            return ResponseEntity.ok(Collections.singletonMap("message", "Usuario desbaneado correctamente"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", "Usuario no encontrado"));
        }
    }



    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/banned-users")
    public ResponseEntity<List<User>> getBannedUsers() {
        List<User> bannedUsers = userService.getBannedUsers();
        return ResponseEntity.ok(bannedUsers);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/unbanned-users")
    public ResponseEntity<List<User>> getUnBannedUsers() {
        List<User> bannedUsers = userService.getUnBannedUsers();
        return ResponseEntity.ok(bannedUsers);
    }






}

package org.example.oncocoderswebapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.example.oncocoderswebapp.DTO.FullUserDTO;
import org.example.oncocoderswebapp.DTO.UserLoginDTO;
import org.example.oncocoderswebapp.DTO.UserRegisterDTO;
import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;


    public Optional<Map<String, Object>> authenticate(UserLoginDTO loginDTO) {
        Optional<User> optionalUser = userRepository.findByEmail(loginDTO.getEmail());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Verificamos las credenciales del usuario y que no esté baneado
            if (passwordEncoder.matches(loginDTO.getPassword(), user.getEncodedPassword()) && !user.isBanned()) {
                String token = tokenService.generateToken(user);

                Map<String, Object> response = new HashMap<>();
                response.put("user", new FullUserDTO(user));
                response.put("token", token); // Este token será usado para la respuesta

                return Optional.of(response);
            }
        }
        return Optional.empty();
    }


    public boolean isEmailTaken(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        return optionalUser.isPresent();
    }


    public User registerUser(UserRegisterDTO registerDTO) {
        try {
            User user = new User();
            user.setName(registerDTO.getName());
            user.setEmail(registerDTO.getEmail());
            user.setEncodedPassword(passwordEncoder.encode(registerDTO.getPassword()));
            user.setComunidadAutonoma(registerDTO.getComunidadAutonoma());
            user.setHospitalReferencia(registerDTO.getHospitalReferencia());

            // Asignar el rol según el email
            if (registerDTO.getEmail().toLowerCase().contains("hospital")) {
                user.setRole("MEDICUSER");  // Asignar rol MEDICUSER si "hospital" está en el email
            }
            else if (registerDTO.getEmail().toLowerCase().contains("investigador")) {
                user.setRole("RESEARCHERUSER");  // Asignar rol RESEARCHERUSER si "investigador" está en el email
            }
            else {
                user.setRole("USER");  // Si no, asignar rol USER
            }

            userRepository.save(user);

            // Asignar paciente solo si el rol es MEDICUSER
            if ("USER".equals(user.getRole())) {
                userService.asignarPacienteAMedico(user);
            }

            return user;
        } catch (Exception e) {
            return null;
        }
    }





}

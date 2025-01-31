package org.example.oncocoderswebapp.service;

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
    private PasswordEncoder passwordEncoder;

    public Optional<FullUserDTO> authenticate(UserLoginDTO loginDTO) {
        Optional<User> optionalUser = userRepository.findByEmail(loginDTO.getEmail());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(loginDTO.getPassword(), user.getEncodedPassword()) && !user.isBanned()) {
                return Optional.of(new FullUserDTO(user));
            }
        }
        return Optional.empty();
    }

    public boolean isEmailTaken(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        return optionalUser.isPresent();
    }

    // Método para registrar al usuario
    public boolean registerUser(UserRegisterDTO registerDTO) {
        try {
            User user = new User();
            user.setName(registerDTO.getName());
            user.setEmail(registerDTO.getEmail());
            user.setEncodedPassword(passwordEncoder.encode(registerDTO.getPassword())); // Encriptación de la contraseña

            // Verificar si el email contiene la palabra "investigador"
            if (registerDTO.getEmail().toLowerCase().contains("sanitario")) {
                user.setRole("CLINICUSER");
            } else {
                user.setRole(registerDTO.getRole());
            }

            userRepository.save(user);  // Guardamos el nuevo usuario en la base de datos
            return true;
        } catch (Exception e) {
            // Manejo de error en el registro
            return false;
        }
    }
}

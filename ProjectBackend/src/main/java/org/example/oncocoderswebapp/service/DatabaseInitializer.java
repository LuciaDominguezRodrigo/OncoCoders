package org.example.oncocoderswebapp.service;

import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.io.IOException;
import java.sql.SQLException;

@Service
public class DatabaseInitializer {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void init() throws IOException, SQLException {

		User paciente = userRepository.save(new User("Lolo", passwordEncoder.encode("pass"),
				"patient@gmail.com",  "Andalucía", "Hospital Virgen del Rocío", true,"USER"));

		User medico = userRepository.save(new User("Pepe", passwordEncoder.encode("medicpass"),
				"doctorhospital@gmail.com",  "Andalucía", "Hospital Virgen del Rocío", true,"MEDICUSER"));



		User medico2 = userRepository.save(new User("Pepa", passwordEncoder.encode("medicpass"),
				"doctor2hospital@gmail.com",  "Madrid", "Hospital 12 de Octubre", true, "MEDICUSER"));

		User paciente2 = userRepository.save(new User("Lola", passwordEncoder.encode("pass"),
				"patient2@gmail.com",  "Madrid", "Hospital 12 de Octubre", true, "USER"));

		User investigador = userRepository.save(new User("Mar", passwordEncoder.encode("researcherpass"),
				"researcher@gmail.com",  "Barcelona", "Hospital Vall d'Hebron", true, "RESEARCHERUSER"));

		User admin = userRepository.save(new User("Paco", passwordEncoder.encode("adminpass"),
				"admin@gmail.com", "Andalucía", "Hospital Vírgen del Rocío", true, "ADMIN"));

		userService.asignarPacienteAMedico(paciente, medico);
		userService.asignarPacienteAMedico(paciente2, medico2);

	}
}

package org.example.oncocoderswebapp.service;

import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import org.springframework.util.StreamUtils;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
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

		User medico = userRepository.save(new User("Pepe", passwordEncoder.encode("medicpass"),
				"medicohospital@gmail.com",  "Andalucía", "Hospital Virgen del Rocío", true,"MEDICUSER"));

		User paciente = userRepository.save(new User("Lolo", passwordEncoder.encode("pass"),
				"paciente@gmail.com",  "Andalucía", "Hospital Virgen del Rocío", true,"USER"));

		User medico2 = userRepository.save(new User("Pepa", passwordEncoder.encode("medicpass"),
				"medico2hospital@gmail.com",  "Madrid", "Hospital 12 de Octubre", true, "MEDICUSER"));

		User paciente2 = userRepository.save(new User("Lola", passwordEncoder.encode("pass"),
				"paciente2@gmail.com",  "Madrid", "Hospital 12 de Octubre", true, "USER"));

		User investigador = userRepository.save(new User("Mar", passwordEncoder.encode("researcherpass"),
				"investigador@gmail.com",  "Barcelona", "Hospital Vall d'Hebron", true, "RESEARCHERUSER"));

		userService.asignarPacienteAMedico(paciente, medico);
		userService.asignarPacienteAMedico(paciente2, medico2);



	}
}

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
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void init() throws IOException, SQLException {

		ClassPathResource imgFile = new ClassPathResource("static/img/fotoPerfil.jpg");
		byte[] photoBytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
		Blob photoBlob1 = new SerialBlob(photoBytes);

		userRepository.save(new User("user", passwordEncoder.encode("pass"),"oncocodersUser@hmail.com",photoBlob1 ,"USER"));
		userRepository.save(new User("clinicUser", passwordEncoder.encode("clinicpass"),"oncocodersclinicdUser@hmail.com",photoBlob1 ,"CLINICUSER"));
		userRepository.save(new User("admin", passwordEncoder.encode("adminpass"),"oncocodersAdmin@hmail.com",photoBlob1,  "ADMIN"));
	}
}

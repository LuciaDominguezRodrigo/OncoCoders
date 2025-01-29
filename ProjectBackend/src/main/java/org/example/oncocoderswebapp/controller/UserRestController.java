package org.example.oncocoderswebapp.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.example.oncocoderswebapp.DTO.CensoredUserDTO;
import org.example.oncocoderswebapp.DTO.FullUserDTO;
import org.example.oncocoderswebapp.DTO.NewUserDTO;
import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.repository.UserRepository;
import org.example.oncocoderswebapp.service.TokenService;
import org.example.oncocoderswebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;


	private static Map<String, TokenService> tokens = new HashMap<>(); //for sesion tokens


	@GetMapping("/me")
	public ResponseEntity<FullUserDTO> currentUser(HttpServletRequest request){
		Principal principal = request.getUserPrincipal();
		if(principal != null) {
			return ResponseEntity.ok(new FullUserDTO(userService.findByName(principal.getName()).orElseThrow()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<CensoredUserDTO> getUser(HttpServletRequest request, @PathVariable Long id){
		Optional<User> optionalUser = userService.findById(id);
		if (optionalUser.isEmpty()) {
			return ResponseEntity.status(404).build();
		}

		User user = optionalUser.get();
		Principal principal = request.getUserPrincipal();
		if (principal != null){
			Optional<User> userPrincipalOptional = userService.findByEmail(principal.getName()); // Buscar por email
			if (userPrincipalOptional.isPresent()) {
				User userPrincipal = userPrincipalOptional.get();
				if (userPrincipal.hasRole("ADMIN")) {
					return ResponseEntity.ok(new FullUserDTO(user));
				}
			}
		}

		if (principal != null && user.getEmail().equals(principal.getName())) { // Comparar por email
			return ResponseEntity.ok(new FullUserDTO(user));
		} else {
			return ResponseEntity.ok(new CensoredUserDTO(user));
		}

	}

	@PostMapping
	public ResponseEntity<FullUserDTO> newUser(@RequestBody NewUserDTO userDTO){
		User user = new User(userDTO);
		if (userService.findByEmail(user.getEmail()).isPresent()) {
			return ResponseEntity.status(409).build(); //409 conflict
		}

		if (!userService.isValidUser(user)){
			return ResponseEntity.badRequest().build();
		}

		String encodedPassword = passwordEncoder.encode(user.getEncodedPassword());
		user.setEncodedPassword(encodedPassword);
		user.clearRoles();
		user.setRole("USER");
		user.setDefaultProfilePicture();

		userService.save(user);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/users/"+user.getId());

		FullUserDTO fullUserDTO = new FullUserDTO(user);
		return new ResponseEntity<>(fullUserDTO, headers, HttpStatus.CREATED);
	}






}

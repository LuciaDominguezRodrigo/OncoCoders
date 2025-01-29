package org.example.oncocoderswebapp.model;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import org.example.oncocoderswebapp.DTO.NewUserDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import javax.sql.rowset.serial.SerialBlob;

@Entity(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@JsonIgnore
	private String encodedPassword;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	private boolean banned;

	@Lob
	private Blob photo;

	@Column(unique = true)
	private String email;

	public User() {
	}

	public User(String name, String encodedPassword, String email, Blob photo, String... roles) {
		this.name = name;
		this.encodedPassword = encodedPassword;
		this.email = email;
		this.banned = false;
		this.roles = List.of(roles);

		if (photo!=null) {
			this.photo = photo;
		}
		else{ this.setDefaultProfilePicture();}
	}

	public User(NewUserDTO userDTO) {
		this.name = userDTO.getName();
		this.email = userDTO.getEmail();
		this.roles = new ArrayList<>(List.of("USER"));
		this.banned = false;
		this.encodedPassword = userDTO.getPassword();
		this.setDefaultProfilePicture();
	}

	public void setDefaultProfilePicture() {
			try {
				ClassPathResource imgFile = new ClassPathResource("static/img/fotoPerfil.jpg");
				byte[] photoBytes = new byte[0];
				photoBytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
				this.photo = new SerialBlob(photoBytes);
			} catch (IOException | SQLException e) {
				throw new RuntimeException(e);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isBanned() {
		return banned;
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRole(String roleUser) {
		if (this.roles == null){
			this.roles =  new ArrayList<>();
		}
		this.roles.add(roleUser);
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getEncodedPassword() {
		return encodedPassword;
	}

	public void setEncodedPassword(String encodedPassword) {
		this.encodedPassword = encodedPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean hasRole(String role) {
		return this.roles.contains(role);
	}

	public void clearRoles() {
		if (this.roles !=null) {
			this.roles.clear();
		} else {
			this.roles = new ArrayList<>();
		}
	}

}
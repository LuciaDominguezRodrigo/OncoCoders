package org.example.oncocoderswebapp.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


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

	@Column(unique = true)
	private String email;

	private String comunidadAutonoma;
	private String hospitalReferencia;

	@OneToMany(mappedBy = "medicUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<User> pacientes = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "medic_user_id")
	@JsonIgnore
	private User medicUser;

	public User() {
	}

	public User(String name, String encodedPassword, String email, String comunidadAutonoma, String hospitalReferencia, String... roles) {
		this.name = name;
		this.encodedPassword = encodedPassword;
		this.email = email;
		this.banned = false;
		this.roles = List.of(roles);
		this.comunidadAutonoma = comunidadAutonoma;
		this.hospitalReferencia = hospitalReferencia;

	}


	public boolean addPaciente(User paciente) {
		if (this.roles.contains("MEDICUSER") && this.pacientes.size() < 20) {
			if (this.comunidadAutonoma.equals(paciente.getComunidadAutonoma()) &&
					this.hospitalReferencia.equals(paciente.getHospitalReferencia())) {

				this.pacientes.add(paciente);
				paciente.medicUser = this;  // Asignamos el médico al paciente

				return true;
			}
		}
		return false;
	}


	public void setMedicUser(User medicUser) {
		if (medicUser != null && medicUser.getRoles().contains("MEDICUSER")) {
			this.medicUser = medicUser;
			medicUser.addPaciente(this);
		}
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public boolean isBanned() { return banned; }
	public void setBanned(boolean banned) { this.banned = banned; }
	public List<String> getRoles() { return roles; }
	public void setRoles(List<String> roles) { this.roles = roles; }
	public String getEncodedPassword() { return encodedPassword; }
	public void setEncodedPassword(String encodedPassword) { this.encodedPassword = encodedPassword; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getComunidadAutonoma() { return comunidadAutonoma; }
	public void setComunidadAutonoma(String comunidadAutonoma) { this.comunidadAutonoma = comunidadAutonoma; }
	public String getHospitalReferencia() { return hospitalReferencia; }
	public void setHospitalReferencia(String hospitalReferencia) { this.hospitalReferencia = hospitalReferencia; }
	public List<User> getPacientes() { return pacientes; }
	public void setPacientes(List<User> pacientes) { this.pacientes = pacientes; }

	public User getMedicUser() {
		return medicUser != null ? medicUser : new User("Sin médico asignado", "", "", "", "");
	}


	public void setRole(String roleUser) {
		if (this.roles == null){
			this.roles =  new ArrayList<>();
		}
		this.roles.add(roleUser);
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

	public String getRole() {
		return this.roles.getFirst();
	}
}
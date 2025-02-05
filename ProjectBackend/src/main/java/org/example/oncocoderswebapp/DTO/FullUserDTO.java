package org.example.oncocoderswebapp.DTO;

import org.example.oncocoderswebapp.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

public class FullUserDTO extends CensoredUserDTO implements UserDetails {
    private Long id;
    private String name;
    private String email;
    private String photo;

    private boolean banned;
    private List<String> roles;

    public FullUserDTO(String name, String email, boolean banned, List<String> roles, Long id) {
        super(name, id);
        this.name = name;
        this.email = email;
        this.banned = banned;
        this.roles = roles;
        this.id = id;
    }

    public FullUserDTO(User user) {
        super(user.getName(), user.getId());
        this.name = user.getName();
        this.email = user.getEmail();
        this.banned = user.isBanned();
        this.roles = user.getRoles();
        this.id = user.getId();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    // Métodos requeridos por la interfaz UserDetails

    @Override
    public String getUsername() {
        return this.email;  // Usamos el email como nombre de usuario
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        // Convertir los roles a una lista de autoridades
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Aquí puedes aplicar tu lógica para determinar si la cuenta ha expirado
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.banned;  // Si está baneado, la cuenta está bloqueada
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Devolver true si las credenciales no han expirado
    }

    @Override
    public boolean isEnabled() {
        return !this.banned;  // Si está baneado, no está habilitado
    }
}

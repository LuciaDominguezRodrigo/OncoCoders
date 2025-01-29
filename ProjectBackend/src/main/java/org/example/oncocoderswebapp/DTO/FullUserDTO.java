package org.example.oncocoderswebapp.DTO;

import org.example.oncocoderswebapp.model.User;

import java.util.List;

public class FullUserDTO extends CensoredUserDTO{
    private Long id;
    private String name;
    private String email;
    private String photo;

    private boolean banned;
    private List<String> roles;

    public FullUserDTO(String name, String email, boolean banned, List<String> roles, Long id) {
        super(name,id);
        this.name = name;
        this.email = email;
        this.banned = banned;
        this.roles = roles;
        this.id = id;
        this.photo = "/api/users/img/" + id;
    }

    public FullUserDTO(User user) {
        super(user.getName(), user.getId());
        this.name = user.getName();
        this.email = user.getEmail();
        this.banned = user.isBanned();
        this.roles = user.getRoles();
        this.id = user.getId();
        this.photo = "/api/users/img/" + user.getId();
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

    @Override
    public String getPhoto() {
        return photo;
    }

    @Override
    public void setPhoto(String photo) {
        this.photo = photo;
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

}

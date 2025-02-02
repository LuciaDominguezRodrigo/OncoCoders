package org.example.oncocoderswebapp.DTO;

import org.example.oncocoderswebapp.model.User;


public class CensoredUserDTO {
    private Long id;
    private String name;
    private String photo;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public CensoredUserDTO(String name, Long id) {
        this.name = name;
        this.id = id;
        this.photo = "/api/users/img/" + id;
    }

    public CensoredUserDTO(User user) {
        this.name = user.getName();
        this.id = user.getId();
        this.photo = "/api/users/img/" + user.getId();
    }
}

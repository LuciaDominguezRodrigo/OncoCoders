package org.example.oncocoderswebapp.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.oncocoderswebapp.model.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDTO {
    private String name;
    private String username;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public NewUserDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = "";
    }
}


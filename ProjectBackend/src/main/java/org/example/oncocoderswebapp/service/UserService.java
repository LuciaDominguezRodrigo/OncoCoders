package org.example.oncocoderswebapp.service;


import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Optional<User> findByName(String name) {
        return this.userRepository.findByName(name);
    }

    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean isValidUser(User user) {
        Long id = user.getId();
        String name = user.getName();
        String email = user.getEmail();
        String password = user.getEncodedPassword();

        if (id!=null) {
            return false;
        } else if (name==null || name.isEmpty()){
            return false;
        } else if (email==null || email.isEmpty()){
            return false;
        } else if (password==null || password.isEmpty()){
            return false;
        }
        return true;

    }

    public void save(User user) {
        if (user.getPhoto()==null) user.setDefaultProfilePicture();
        this.userRepository.save(user);
    }
}

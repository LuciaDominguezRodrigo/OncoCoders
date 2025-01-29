package org.example.oncocoderswebapp.repository;

import java.util.Optional;

import org.example.oncocoderswebapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

}

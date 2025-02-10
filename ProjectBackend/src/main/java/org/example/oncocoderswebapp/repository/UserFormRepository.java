package org.example.oncocoderswebapp.repository;

import org.example.oncocoderswebapp.model.UserFormResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFormRepository  extends JpaRepository<UserFormResponse, Long>{
    List<UserFormResponse> findAll();
}

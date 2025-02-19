package org.example.oncocoderswebapp.repository;

import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.model.UserDiagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosisRepository extends JpaRepository<UserDiagnosis,Long> {
    List<UserDiagnosis> findByUsuarioOrderByIdAsc(User user);
}

package org.example.oncocoderswebapp.repository;

import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.model.UserDiagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiagnosisRepository extends JpaRepository<UserDiagnosis,Long> {

    Optional<UserDiagnosis >findByUsuario(User usuario);
    @Query("SELECT d FROM diagnosis d WHERE d.usuario = :user ORDER BY d.id DESC LIMIT 1")
    Optional<UserDiagnosis> findTopByUserOrderByFechaRegistroDesc(@Param("user") User user);

    List<UserDiagnosis> findByUsuarioOrderByIdAsc(User user);
}

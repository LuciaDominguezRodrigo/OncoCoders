package org.example.oncocoderswebapp.repository;

import java.util.List;
import java.util.Optional;

import org.example.oncocoderswebapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM USERS u WHERE u.comunidadAutonoma = :comunidad AND u.hospitalReferencia = :hospital AND :role MEMBER OF u.roles")
    List<User> findAvailableDoctors(@Param("comunidad") String comunidad, @Param("hospital") String hospital, @Param("role") String role);

    @Query("SELECT u FROM USERS u WHERE u.comunidadAutonoma = :comunidad AND u.hospitalReferencia = :hospital AND 'MEDICUSER' MEMBER OF u.roles")
    List<User> findAvailableDoctorsByHospital(@Param("comunidad") String comunidad, @Param("hospital") String hospital);

    @Query("SELECT u FROM USERS u WHERE u.comunidadAutonoma = :comunidad AND 'MEDICUSER' MEMBER OF u.roles")
    List<User> findAvailableDoctorsByCommunity(@Param("comunidad") String comunidad);


    List<User> findByMedicUserEmail(String email);
}

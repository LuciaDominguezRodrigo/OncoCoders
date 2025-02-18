package org.example.oncocoderswebapp.repository;

import org.example.oncocoderswebapp.model.UserDiagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends JpaRepository<UserDiagnosis,Long> {
}

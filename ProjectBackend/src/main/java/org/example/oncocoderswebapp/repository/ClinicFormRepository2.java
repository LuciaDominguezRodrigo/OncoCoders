package org.example.oncocoderswebapp.repository;

import org.example.oncocoderswebapp.model.ClinicFormResponse2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicFormRepository2 extends JpaRepository<ClinicFormResponse2,Long> {
}

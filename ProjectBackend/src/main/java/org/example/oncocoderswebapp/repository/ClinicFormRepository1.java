package org.example.oncocoderswebapp.repository;

import org.example.oncocoderswebapp.model.ClinicFormResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicFormRepository1 extends JpaRepository<ClinicFormResponse,Long>
{
}

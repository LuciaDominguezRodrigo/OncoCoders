package org.example.oncocoderswebapp.service;

import org.example.oncocoderswebapp.model.UserDiagnosis;
import org.example.oncocoderswebapp.repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    public void save(UserDiagnosis userDiagnosis) {
        this.diagnosisRepository.save(userDiagnosis);
    }
}

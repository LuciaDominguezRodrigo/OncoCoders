package org.example.oncocoderswebapp.controller;


import org.example.oncocoderswebapp.DTO.ClinicFormRequest2DTO;
import org.example.oncocoderswebapp.DTO.ClinicFormRequestDTO;
import org.example.oncocoderswebapp.model.ClinicFormResponse;
import org.example.oncocoderswebapp.model.ClinicFormResponse2;
import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.service.ClinicFormService;
import org.example.oncocoderswebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/clinicForm")
public class ClinicFormController {

        @Autowired
        private ClinicFormService clinicFormService;

        @Autowired
        private UserService userService; // Para buscar el usuario por email

        @PreAuthorize("hasRole('MEDICUSER')")
        @PostMapping("/saveResponse1")
        public ResponseEntity<ClinicFormResponse> saveClinicFormResponse1(@RequestBody ClinicFormRequestDTO request, @RequestHeader("Authorization") String token) {
            if (token == null || token.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(null);
            }
            // Buscar el paciente por email
            Optional<User> patientUser = userService.findByEmail(request.getPatientEmail());
            if (patientUser.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            User puser = new User();
            puser = patientUser.get();

            // Crear la respuesta del formulario
            ClinicFormResponse response;
            response = new ClinicFormResponse();
            response.setPatientUser(puser);


            ClinicFormResponse savedResponse = clinicFormService.saveClinicFormResponse1(request,puser);
            return ResponseEntity.ok(savedResponse);
        }

    @PostMapping("/saveResponse2")
    public ResponseEntity<ClinicFormResponse2> saveClinicFormResponse2(@RequestBody ClinicFormRequest2DTO request, @RequestHeader("Authorization") String token) {
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
        // Buscar el paciente por email
        Optional<User> patientUser = userService.findByEmail(request.getPatientEmail());
        if (patientUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        User puser = new User();
        puser = patientUser.get();

        // Crear la respuesta del formulario
        ClinicFormResponse response;
        response = new ClinicFormResponse();
        response.setPatientUser(puser);


        ClinicFormResponse2 savedResponse = clinicFormService.saveClinicFormResponse2(request,puser);
        return ResponseEntity.ok(savedResponse);
    }
    }





package org.example.oncocoderswebapp.controller;


import org.example.oncocoderswebapp.DTO.ClinicFormRequestDTO;
import org.example.oncocoderswebapp.model.ClinicFormResponse;
import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.service.ClinicFormService;
import org.example.oncocoderswebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/clinicForm")
public class ClinicFormController {



        @Autowired
        private ClinicFormService clinicFormService;

        @Autowired
        private UserService userService; // Para buscar el usuario por email

        @PostMapping("/saveResponse1")
        public ResponseEntity<ClinicFormResponse> saveClinicFormResponse1(@RequestBody ClinicFormRequestDTO request) {
            // Buscar el paciente por email
            Optional<User> patientUser = userService.findByEmail(request.getPatientEmail());
            if (patientUser.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            User puser = new User();
            puser = patientUser.get();

            // Crear la respuesta del formulario
            ClinicFormResponse response = new ClinicFormResponse();
            response.setPatientUser(puser);

            Optional<User> medic = this.userService.findById(request.getMedicUserId());
            if (medic.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }


            // Guardar en la base de datos
            ClinicFormResponse savedResponse = clinicFormService.saveClinicFormResponse1(request,puser, medic.get());
            return ResponseEntity.ok(savedResponse);
        }
    }





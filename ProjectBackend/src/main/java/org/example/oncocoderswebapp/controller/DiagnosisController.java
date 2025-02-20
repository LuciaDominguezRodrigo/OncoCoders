package org.example.oncocoderswebapp.controller;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.example.oncocoderswebapp.model.UserDiagnosis;
import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.service.DiagnosisService;
import org.example.oncocoderswebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/api/diagnosis")
public class DiagnosisController {

    @Autowired
    private UserService userService; // Repositorio de Usuario
    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    private DiagnosisService userDiagnosisService; // Repositorio de UserDiagnosis

    @PostMapping("/upload")
    public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file, @RequestParam("modelName") String modelName) {
        try {
            diagnosisService.processExcel(file, modelName);
            return ResponseEntity.ok("File processed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing file: " + e.getMessage());
        }
    }

    @GetMapping("/latest-complete")
    public ResponseEntity<UserDiagnosis> getLatestCompleteDiagnosis(@RequestParam("userId") Long userId) {
        Optional<UserDiagnosis> latestDiagnosis = diagnosisService.findLatestCompleteDiagnosis(userId);
        return latestDiagnosis.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}

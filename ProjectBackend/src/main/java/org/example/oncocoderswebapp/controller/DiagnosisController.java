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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/diagnosis")
public class DiagnosisController {

    @Autowired
    private UserService userService; // Repositorio de Usuario

    @Autowired
    private DiagnosisService userDiagnosisService; // Repositorio de UserDiagnosis

    @PostMapping("/upload")
    public ResponseEntity<String> uploadResultados(@RequestParam("file") MultipartFile file) {
        try {
            // Cargar el archivo Excel
            Workbook workbook = WorkbookFactory.create(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0); // Tomamos la primera hoja

            // Iteramos sobre las filas del Excel
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    // Omite la primera fila (encabezados)
                    continue;
                }

                Long userId = (long) row.getCell(0).getNumericCellValue();
                User usuario = userService.findById(userId)
                        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

                String modelo1 = row.getCell(1).getStringCellValue();
                String modelo2 = row.getCell(2).getStringCellValue();
                String modelo3 = row.getCell(3).getStringCellValue();
                String modelo4 = row.getCell(4).getStringCellValue();

                // Crear la entidad de UserDiagnosis
                UserDiagnosis userDiagnosis = new UserDiagnosis(usuario, modelo1, modelo2, modelo3, modelo4);

                // Guardar en la base de datos
                userDiagnosisService.save(userDiagnosis);
            }

            workbook.close(); // Cerramos el libro de trabajo

            return ResponseEntity.ok("Archivo procesado y resultados guardados exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar el archivo.");
        }
    }
}

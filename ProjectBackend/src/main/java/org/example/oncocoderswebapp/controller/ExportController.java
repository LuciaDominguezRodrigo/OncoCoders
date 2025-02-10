package org.example.oncocoderswebapp.controller;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/excels")
public class ExportController {


    @GetMapping("/export-answers")
    public ResponseEntity<ByteArrayResource> exportarExcel() throws IOException, IOException {
        // Crear el archivo Excel en memoria
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Respuestas");

        // Crear encabezados
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Pregunta");
        headerRow.createCell(1).setCellValue("Respuesta");

        //datos de ejemplo, hay que refactorizar
        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue("¿Cómo estás?");
        dataRow.createCell(1).setCellValue("Bien");

        workbook.write(outputStream);
        workbook.close();

        ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=respuestas.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(outputStream.size())
                .body(resource);
    }


}

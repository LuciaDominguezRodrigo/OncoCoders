package org.example.oncocoderswebapp.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.oncocoderswebapp.model.ClinicFormResponse;
import org.example.oncocoderswebapp.model.ClinicFormResponse2;
import org.example.oncocoderswebapp.model.UserFormResponse;
import org.example.oncocoderswebapp.service.ClinicFormService;
import org.example.oncocoderswebapp.service.UserFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/excels")
public class ExportController {
    @Autowired
    private final UserFormService formResponseService;
    @Autowired
    private final ClinicFormService ClinicformResponseService;
    @Autowired
    private ClinicFormService clinicFormService;

    public ExportController(UserFormService formResponseService, ClinicFormService clinicformResponseService) {
        this.formResponseService = formResponseService;
        ClinicformResponseService = clinicformResponseService;
    }


    @GetMapping("/export-answers2")
    public ResponseEntity<ByteArrayResource> exportarExcel2() throws IOException {
        // Obtener datos
        List<UserFormResponse> respuestas = formResponseService.getResponses();
        if (respuestas == null || respuestas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new ByteArrayResource(new byte[0])); // Devolver un archivo vacío en caso de que no haya datos
        }

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Respuestas");
            Row headerRow = sheet.createRow(0);
            String[] headers = { "id_paciente", "sexo_biologico", "bulto_masa_senos", "dolor_persistente_senos_axilas",
                                 "cambios_piel_senos", "cambios_pezones", "ganglios_inflamados_axilas",
                                 "enfermedades_cronicas", "numero_familiares_diagnosticados", "edad_menopausia",
                                 "primera_menstruacion", "lactancia", "fumar", "anticonceptivos_hormonales_5",
                                 "sobrepeso_obesidad", "grasas_saturadas", "grasas_saludables", "fruta_verdura",
                                 "incorporacion_fibra", "cancer_mama" };

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            int rowNum = 1;
            for (UserFormResponse respuesta : respuestas) {
                Row dataRow = sheet.createRow(rowNum++);
                dataRow.createCell(0).setCellValue(respuesta.getUsuario_id());
                dataRow.createCell(1).setCellValue(respuesta.getSexo());
                dataRow.createCell(2).setCellValue(respuesta.getBulto());
                dataRow.createCell(3).setCellValue(respuesta.getDolor_senos_axilas());
                dataRow.createCell(4).setCellValue(respuesta.getCambios_hinchazon_piel_senos());
                dataRow.createCell(5).setCellValue(respuesta.getPezones_rectacion_secrecion());
                dataRow.createCell(6).setCellValue(respuesta.getGanglios_inflamados_dolor());
                dataRow.createCell(7).setCellValue(respuesta.getSobrepeso_obesidad());
                dataRow.createCell(8).setCellValue(respuesta.getNum_familiares_diagnosticados());
                dataRow.createCell(9).setCellValue(respuesta.getEdad_menopausia());
                dataRow.createCell(10).setCellValue(respuesta.getPrimera_menstruacion());
                dataRow.createCell(11).setCellValue(respuesta.getHijos_lactancia());
                dataRow.createCell(12).setCellValue(respuesta.getFumar());
                dataRow.createCell(13).setCellValue(respuesta.getAnticonceptivos_hormonales_5());
                dataRow.createCell(14).setCellValue(respuesta.getSobrepeso_obesidad());
                dataRow.createCell(15).setCellValue(respuesta.getGrasas_saturadas());
                dataRow.createCell(16).setCellValue(respuesta.getGrasas_saludables());
                dataRow.createCell(17).setCellValue(respuesta.getFruta_verdura());
                dataRow.createCell(18).setCellValue(respuesta.getIncorporacion_fibra());
                dataRow.createCell(19).setCellValue(respuesta.getCancer_mama());
            }

            // Escribir el archivo a memoria en lugar de guardarlo en disco
            workbook.write(bos);
            ByteArrayResource resource = new ByteArrayResource(bos.toByteArray());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Modelo2.xlsx")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(bos.size())
                    .body(resource);
        }
    }

    @GetMapping("/export-answers4")
    public ResponseEntity<ByteArrayResource> exportarExcel4() throws IOException {
        // Obtener datos
        List<UserFormResponse> respuestas = formResponseService.getResponses();
        if (respuestas == null || respuestas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new ByteArrayResource(new byte[0])); // Devolver un archivo vacío en caso de que no haya datos
        }

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Respuestas");
            Row headerRow = sheet.createRow(0);
            String[] headers = { "id_paciente", "edad", "tratamiento_actualmente", "tipos_tratamiento",
                    "enfermedades_cronicas", "frequencia_act_fisica", "frecuencia_alcohol", "fumar", "sobrepeso_obesidad",
                     "grasas_saturadas", "grasas_saludables", "fruta_verdura", "incorporacion_fibra","edad_menopausia","recurrencia"};

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            int rowNum = 1;
            for (UserFormResponse respuesta : respuestas) {
                Row dataRow = sheet.createRow(rowNum++);

                dataRow.createCell(0).setCellValue(respuesta.getUsuario_id());
                dataRow.createCell(1).setCellValue(respuesta.getEdad());
                dataRow.createCell(2).setCellValue(respuesta.getTratamiento_actualmente());
                dataRow.createCell(3).setCellValue(respuesta.getTipos_tratamiento());
                dataRow.createCell(4).setCellValue(respuesta.getHipertension_diabtetes());
                dataRow.createCell(5).setCellValue(respuesta.getFrequencia_act_fisica());
                dataRow.createCell(6).setCellValue(respuesta.getFrecuencia_alcohol());
                dataRow.createCell(7).setCellValue(respuesta.getFumar());
                dataRow.createCell(8).setCellValue(respuesta.getSobrepeso_obesidad());
                dataRow.createCell(9).setCellValue(respuesta.getGrasas_saturadas());
                dataRow.createCell(10).setCellValue(respuesta.getGrasas_saludables());
                dataRow.createCell(11).setCellValue(respuesta.getFruta_verdura());
                dataRow.createCell(12).setCellValue(respuesta.getIncorporacion_fibra());
                dataRow.createCell(13).setCellValue(respuesta.getEdad_menopausia());
                dataRow.createCell(14).setCellValue(respuesta.getCancer_mama());
            }

            // Escribir el archivo a memoria en lugar de guardarlo en disco
            workbook.write(bos);
            ByteArrayResource resource = new ByteArrayResource(bos.toByteArray());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Modelo4.xlsx")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(bos.size())
                    .body(resource);
        }
    }

    @GetMapping("/export-answers1")
    public ResponseEntity<ByteArrayResource> exportarExcel1() throws IOException {
        // Obtener datos
        List<ClinicFormResponse> respuestas = clinicFormService.getResponses1();
        if (respuestas == null || respuestas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new ByteArrayResource(new byte[0])); // Devolver un archivo vacío en caso de que no haya datos
        }

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Respuestas");
            Row headerRow = sheet.createRow(0);
            String[] headers = { "id_paciente", "edad", "edad_menopausia", "raza", "ER", "PR", "HER2", "Mol_subtipo",
            "tamaño_tumor","grado_tumor_nuclear", "grado_tumor_mitotico", "BRCA1", "BRCA2", "numrero_familiares_diagnosticados",
            "radioterapia_pecho", "edad_mesntruacion", "cancer_mama"};

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            int rowNum = 1;
            for (ClinicFormResponse respuesta : respuestas) {
                Row dataRow = sheet.createRow(rowNum++);

                dataRow.createCell(0).setCellValue(respuesta.getPatientUser().getId());
                dataRow.createCell(1).setCellValue(respuesta.getEdad());
                dataRow.createCell(2).setCellValue(respuesta.getEdad_menopausia());
                dataRow.createCell(3).setCellValue(respuesta.getEtnia());
                dataRow.createCell(4).setCellValue(respuesta.getHormona_ER());
                dataRow.createCell(5).setCellValue(respuesta.getHormona_PR());
                dataRow.createCell(6).setCellValue(respuesta.getHormona_HER2());
                dataRow.createCell(7).setCellValue(respuesta.getSubtipo_molecular());
                dataRow.createCell(8).setCellValue(respuesta.getTamannio_tumor());
                dataRow.createCell(9).setCellValue(respuesta.getEstructura_general());
                dataRow.createCell(10).setCellValue(respuesta.getCapaciadd_estado_miotico());
                dataRow.createCell(11).setCellValue(respuesta.getMutacion_BRCA1());
                dataRow.createCell(12).setCellValue(respuesta.getMutacion_BRCA2());
                dataRow.createCell(13).setCellValue(respuesta.getFamiliares_diagnosticados());
                dataRow.createCell(14).setCellValue(respuesta.getRadioterapia_anterior());
                dataRow.createCell(15).setCellValue(respuesta.getEdad_mesntruacion());
                dataRow.createCell(16).setCellValue(respuesta.getCancer_mama());
            }

            // Escribir el archivo a memoria en lugar de guardarlo en disco
            workbook.write(bos);
            ByteArrayResource resource = new ByteArrayResource(bos.toByteArray());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Modelo4.xlsx")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(bos.size())
                    .body(resource);
        }
    }

    @GetMapping("/export-answers3")
    public ResponseEntity<ByteArrayResource> exportarExcel3() throws IOException {
        // Obtener datos
        List<ClinicFormResponse2> respuestas = clinicFormService.getResponses2();
        if (respuestas == null || respuestas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new ByteArrayResource(new byte[0])); // Devolver un archivo vacío en caso de que no haya datos
        }

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Respuestas");
            Row headerRow = sheet.createRow(0);
            String[] headers = { "id_paciente", "edad", "edad_menopausia", "raza", "ER", "PR", "HER2", "Mol_subtipo",
                    "tamaño_tumor","grado_tumor_tubular", "grado_tumor_nuclear", "grado_tumor_mitotico", "BRCA1", "BRCA2", "numrero_familiares_diagnosticados",
                    "operación", "tipo_operación", "tratamiento_actualmente","tipo_tratamiento", "radioterapia_pecho", "enfermedad_cronicas", "recurrencia"};

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            int rowNum = 1;
            for (ClinicFormResponse2 respuesta : respuestas) {
                Row dataRow = sheet.createRow(rowNum++);

                dataRow.createCell(0).setCellValue(respuesta.getPatientUser().getId());
                dataRow.createCell(1).setCellValue(respuesta.getEdad());
                dataRow.createCell(2).setCellValue(respuesta.getEdad_menopausia());
                dataRow.createCell(3).setCellValue(respuesta.getEtnia());
                dataRow.createCell(4).setCellValue(respuesta.getHormona_ER());
                dataRow.createCell(5).setCellValue(respuesta.getHormona_PR());
                dataRow.createCell(6).setCellValue(respuesta.getHormona_HER2());
                dataRow.createCell(7).setCellValue(respuesta.getSubtipo_molecular());
                dataRow.createCell(8).setCellValue(respuesta.getTamannio_tumor());
                dataRow.createCell(9).setCellValue(respuesta.getEstructura_tubular());
                dataRow.createCell(10).setCellValue(respuesta.getEstructura_general());
                dataRow.createCell(11).setCellValue(respuesta.getCapaciadd_estado_miotico());
                dataRow.createCell(12).setCellValue(respuesta.getMutacion_BRCA1());
                dataRow.createCell(13).setCellValue(respuesta.getMutacion_BRCA2());
                dataRow.createCell(14).setCellValue(respuesta.getFamiliares_diagnosticados());
                dataRow.createCell(15).setCellValue(respuesta.getOperacion());
                dataRow.createCell(16).setCellValue(respuesta.getOperacion_tipo());
                dataRow.createCell(17).setCellValue(respuesta.getTratamiento_actual());
                dataRow.createCell(18).setCellValue(respuesta.getTipos_tratamiento());
                dataRow.createCell(19).setCellValue(respuesta.getRadioterapia_anterior());
                dataRow.createCell(20).setCellValue(respuesta.getSobrepeso_obesidad());
                dataRow.createCell(21).setCellValue(respuesta.getCancer_mama_antes());
            }

            // Escribir el archivo a memoria en lugar de guardarlo en disco
            workbook.write(bos);
            ByteArrayResource resource = new ByteArrayResource(bos.toByteArray());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Modelo4.xlsx")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(bos.size())
                    .body(resource);
        }
    }


}

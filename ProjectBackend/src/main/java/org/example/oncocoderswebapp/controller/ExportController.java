package org.example.oncocoderswebapp.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.oncocoderswebapp.model.UserFormResponse;
import org.example.oncocoderswebapp.service.UserFormService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
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

    private final UserFormService formResponseService;

    public ExportController(UserFormService formResponseService) {
        this.formResponseService = formResponseService;
    }


    /*@GetMapping("/export-answers2")
    public ResponseEntity<ByteArrayResource> exportarExcel(
            @RequestParam(required = false, defaultValue = "respuestas_formulario") String filename) throws IOException {

        // Obtener las respuestas del servicio
        List<UserFormResponse> respuestas = formResponseService.getResponses();

        // Definir la carpeta donde se guardará el archivo
        String folderPath = "excels";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Ruta completa del archivo
        String filePath = folderPath + "/" + filename + ".xlsx";
        File file = new File(filePath);

        // Eliminar el archivo si ya existe para evitar duplicados
        if (file.exists()) {
            file.delete();
        }

        // Crear un nuevo archivo Excel
        try (Workbook workbook = new XSSFWorkbook(); FileOutputStream fos = new FileOutputStream(file)) {
            Sheet sheet = workbook.createSheet("Respuestas");

            // Crear la fila de encabezados
            Row headerRow = sheet.createRow(0);
            String[] headers = {
                    "id_paciente", "sexo_biologico", "bulto_masa_senos", "dolor_persistente_senos_axilas", "cambios_piel_senos",
                    "cambios_pezones", "ganglios_inflamados_axilas", "enfermedades_cronicas", "numero_familiares_diagnosticados",
                    "edad_menopausia", "primera_menstruacion", "lactancia", "fumar", "anticonceptivos_hormonales_5",
                    "sobrepeso_obesidad", "grasas_saturadas", "grasas_saludables", "fruta_verdura", "incorporacion_fibra", "cancer_mama"
            };

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            // Agregar datos
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

            // Escribir y cerrar el archivo
            workbook.write(fos);
        }

        // Leer el archivo para enviarlo como respuesta
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(file.toPath()));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename + ".xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(file.length())
                .body(resource);
    }*/

    public void exportarExcel(String filename) throws IOException {
        // Obtener respuestas del servicio
        List<UserFormResponse> respuestas = formResponseService.getResponses();

        // Crear carpeta si no existe
        String folderPath = "excels";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            if (!created) {
                System.out.println("No se puede crear la carpeta " + folderPath);
            }
        }

        // Ruta del archivo
        String filePath = folderPath + "/" + filename + ".xlsx";
        File file = new File(filePath);

        // Si el archivo existe, se sobrescribirá cuando lo abramos para escribir los nuevos datos
        if (file.exists()) {
            System.out.println("El archivo existe, se sobrescribirá: " + filePath);
        } else {
            System.out.println("El archivo no existe, se creará uno nuevo: " + filePath);
        }

        // Crear nuevo archivo Excel y sobrescribir el contenido si ya existe
        try (Workbook workbook = new XSSFWorkbook(); FileOutputStream fos = new FileOutputStream(file)) {
            Sheet sheet = workbook.createSheet("Respuestas");

            // Crear la fila de encabezados
            Row headerRow = sheet.createRow(0);
            String[] headers = {
                    "id_paciente", "sexo_biologico", "bulto_masa_senos", "dolor_persistente_senos_axilas", "cambios_piel_senos",
                    "cambios_pezones", "ganglios_inflamados_axilas", "enfermedades_cronicas", "numero_familiares_diagnosticados",
                    "edad_menopausia", "primera_menstruacion", "lactancia", "fumar", "anticonceptivos_hormonales_5",
                    "sobrepeso_obesidad", "grasas_saturadas", "grasas_saludables", "fruta_verdura", "incorporacion_fibra", "cancer_mama"
            };

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            // Agregar los datos de las respuestas al archivo
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

            // Escribir y cerrar el archivo
            workbook.write(fos);
            System.out.println("Archivo Excel sobrescrito con éxito: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al escribir el archivo Excel: " + e.getMessage());
        }
    }



    @GetMapping("/list-excel-files")
    public ResponseEntity<List<String>> listarArchivosExcel() {
        File folder = new File("excels");
        if (!folder.exists() || !folder.isDirectory()) {
            return ResponseEntity.ok(Collections.emptyList());
        }

        String[] archivos = folder.list((dir, name) -> name.endsWith(".xlsx"));
        assert archivos != null;
        return ResponseEntity.ok(Arrays.asList(archivos));
    }

    @GetMapping("/download-excel/{filename}")
    public ResponseEntity<ByteArrayResource> descargarExcel(@PathVariable String filename) throws IOException {
        this.exportarExcel(filename);
        // Ubicación del archivo
        File file = new File("excels/" + filename + ".xlsx");
        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }

        // Leer el archivo para enviarlo
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(file.toPath()));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename + ".xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(file.length())
                .body(resource);
    }






}

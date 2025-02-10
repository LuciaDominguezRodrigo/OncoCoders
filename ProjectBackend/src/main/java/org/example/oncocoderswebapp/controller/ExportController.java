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
import java.util.List;

@RestController
@RequestMapping("/api/excels")
public class ExportController {

    private final UserFormService formResponseService;

    public ExportController(UserFormService formResponseService) {
        this.formResponseService = formResponseService;
    }


    @GetMapping("/export-answers")
    public ResponseEntity<ByteArrayResource> exportarExcel(
            @RequestParam(required = false, defaultValue = "respuestas_formulario") String filename) throws IOException {

        // Obtener las respuestas del servicio
        List<UserFormResponse> respuestas = formResponseService.getResponses();

        // Crear carpeta "excels" si no existe
        String folderPath = "excels";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Ruta completa del archivo
        String filePath = folderPath + "/" + filename + ".xlsx";
        File file = new File(filePath);

        // Crear o agregar al archivo existente
        Workbook workbook;
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            fis.close();
        } else {
            workbook = new XSSFWorkbook();
        }

        Sheet sheet = workbook.getSheet("Respuestas");
        if (sheet == null) {
            sheet = workbook.createSheet("Respuestas");
        }

        // Crear la primera fila para los encabezados
        Row headerRow = sheet.createRow(0);

        // Definir los encabezados (identificadores proporcionados)
        String[] headers = {
                "edad", "sexo", "bulto", "dolor_senos_axilas", "cambios_hinchazon_piel_senos", "pezones_rectacion_secrecion",
                "ganglios_inflamados_dolor", "perdida_peso_inexplicada", "fatiga_persistente_cansancio_inexplicado",
                "fiebre_inexplicada", "hinchazón_brazos_manos", "dolor_huesos_articulaciones_inexplicado",
                "sudoración_nocturna_excesiva", "diagnostico_previo", "familiares_diagnosticados", "num_familiares_diagnosticados",
                "tratamiento_actualmente", "tipos_tratamiento", "primera_menstruacion", "edad_menopausia", "hijos", "hijos_lactancia",
                "anticonceptivos_hormonales_5", "terapia_remplazo_hormonal_postmenopausia", "frequencia_act_fisica", "frecuencia_alcohol",
                "fumar", "sobrepeso_obesidad", "grasas_saturadas", "grasas_saludables", "fruta_verdura", "incorporacion_fibra",
                "hipertension_diabtetes", "radioterapia_pecho"
        };

        // Rellenar la fila de encabezados con los identificadores
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }

        // Comenzar a agregar los datos a partir de la segunda fila
        int rowNum = 1; // Empieza después de la fila de encabezados

        for (UserFormResponse respuesta : respuestas) {
            Row dataRow = sheet.createRow(rowNum++);

            dataRow.createCell(0).setCellValue(respuesta.getEdad());
            dataRow.createCell(1).setCellValue(respuesta.getSexo());
            dataRow.createCell(2).setCellValue(respuesta.getBulto());
            dataRow.createCell(3).setCellValue(respuesta.getDolor_senos_axilas());
            dataRow.createCell(4).setCellValue(respuesta.getCambios_hinchazon_piel_senos());
            dataRow.createCell(5).setCellValue(respuesta.getPezones_rectacion_secrecion());
            dataRow.createCell(6).setCellValue(respuesta.getGanglios_inflamados_dolor());
            dataRow.createCell(7).setCellValue(respuesta.getPerdida_peso_inexplicada());
            dataRow.createCell(8).setCellValue(respuesta.getFatiga_persistente_cansancio_inexplicado());
            dataRow.createCell(9).setCellValue(respuesta.getFiebre_inexplicada());
            dataRow.createCell(10).setCellValue(respuesta.getHinchazon_brazos_manos());
            dataRow.createCell(11).setCellValue(respuesta.getDolor_huesos_articulaciones_inexplicado());
            dataRow.createCell(12).setCellValue(respuesta.getSudoracion_nocturna_excesiva());
            dataRow.createCell(13).setCellValue(respuesta.getDiagnostico_previo());
            dataRow.createCell(14).setCellValue(respuesta.getFamiliares_diagnosticados());
            dataRow.createCell(15).setCellValue(respuesta.getNum_familiares_diagnosticados());
            dataRow.createCell(16).setCellValue(respuesta.getTratamiento_actualmente());
            dataRow.createCell(17).setCellValue(respuesta.getTipos_tratamiento());
            dataRow.createCell(18).setCellValue(respuesta.getPrimera_menstruacion());
            dataRow.createCell(19).setCellValue(respuesta.getEdad_menopausia());
            dataRow.createCell(20).setCellValue(respuesta.getHijos());
            dataRow.createCell(21).setCellValue(respuesta.getHijos_lactancia());
            dataRow.createCell(22).setCellValue(respuesta.getAnticonceptivos_hormonales_5());
            dataRow.createCell(23).setCellValue(respuesta.getTerapia_remplazo_hormonal_postmenopausia());
            dataRow.createCell(24).setCellValue(respuesta.getFrequencia_act_fisica());
            dataRow.createCell(25).setCellValue(respuesta.getFrecuencia_alcohol());
            dataRow.createCell(26).setCellValue(respuesta.getFumar());
            dataRow.createCell(27).setCellValue(respuesta.getSobrepeso_obesidad());
            dataRow.createCell(28).setCellValue(respuesta.getGrasas_saturadas());
            dataRow.createCell(29).setCellValue(respuesta.getGrasas_saludables());
            dataRow.createCell(30).setCellValue(respuesta.getFruta_verdura());
            dataRow.createCell(31).setCellValue(respuesta.getIncorporacion_fibra());
            dataRow.createCell(32).setCellValue(respuesta.getHipertension_diabtetes());
            dataRow.createCell(33).setCellValue(respuesta.getRadioterapia_pecho());
        }

        // Guardar el archivo
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();
        workbook.close();

        // Leer el archivo para enviarlo como respuesta
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(file.toPath()));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename + ".xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(file.length())
                .body(resource);
    }


}

package org.example.oncocoderswebapp.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.model.UserDiagnosis;
import org.example.oncocoderswebapp.repository.DiagnosisRepository;
import org.example.oncocoderswebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Autowired
    private UserRepository userRepository;

    public void save(UserDiagnosis userDiagnosis) {
        this.diagnosisRepository.save(userDiagnosis);
    }

    public void processExcel(MultipartFile file, String modelName) {
        try (InputStream is = file.getInputStream(); Workbook workbook = WorkbookFactory.create(is)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Saltar encabezados

                Long userId = (long) row.getCell(0).getNumericCellValue();
                Optional<User> userOpt = userRepository.findById(userId);

                if (userOpt.isPresent()) {
                    User user = userOpt.get();

                    // Obtener los diagnósticos ordenados directamente desde la base de datos
                    List<UserDiagnosis> userDiagnoses = diagnosisRepository.findByUsuarioOrderByIdAsc(user);

                    // Iterar sobre las columnas para cada diagnóstico
                    for (int col = 1; col < row.getLastCellNum(); col++) {
                        String result = getCellValue(row, col);

                        if (result != null) { // Evitar valores vacíos
                            int instanceNumber = col; // Número de instancia basado en la columna

                            UserDiagnosis diagnosis;
                            if (userDiagnoses.size() >= instanceNumber) {
                                // Si ya existe la instancia N, la actualizamos
                                diagnosis = userDiagnoses.get(instanceNumber - 1);
                            } else {
                                // Si no existe, se crea una nueva instancia
                                diagnosis = new UserDiagnosis(user, null, null, null, null);
                                diagnosisRepository.save(diagnosis);
                                userDiagnoses.add(diagnosis);
                            }

                            // Asignar el valor al modelo correspondiente
                            switch (modelName) {
                                case "modelo_1":
                                    diagnosis.setModelo1(result);
                                    break;
                                case "modelo_2":
                                    diagnosis.setModelo2(result);
                                    break;
                                case "modelo_3":
                                    diagnosis.setModelo3(result);
                                    break;
                                case "modelo_4":
                                    diagnosis.setModelo4(result);
                                    break;
                                default:
                                    throw new IllegalArgumentException("Modelo no reconocido: " + modelName);
                            }

                            // Guardar la instancia actualizada
                            diagnosisRepository.save(diagnosis);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error processing file: " + modelName, e);
        }
    }

    // Método auxiliar para obtener valores de las celdas
    private String getCellValue(Row row, int index) {
        if (index >= row.getLastCellNum()) return null;
        if (row.getCell(index) == null || row.getCell(index).getCellType() == org.apache.poi.ss.usermodel.CellType.BLANK) {
            return null;
        }
        return row.getCell(index).toString().trim();
    }



}
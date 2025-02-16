package org.example.oncocoderswebapp.service;

import org.example.oncocoderswebapp.DTO.ClinicFormRequestDTO;
import org.example.oncocoderswebapp.model.ClinicFormResponse;
import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.repository.ClinicFormRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClinicFormService {

    @Autowired
    private ClinicFormRepository1 clinicFormRepository1;

        public ClinicFormResponse saveClinicFormResponse1(ClinicFormRequestDTO request, User patientUser) {
            ClinicFormResponse response = new ClinicFormResponse();
            response.setPatientUser(patientUser);
            response.setEdad(convertirANumero(request.getEdad(), "edad"));
            response.setEtnia(convertirANumero(request.getEtnia(), "etnia"));
            response.setEdad_mesntruacion(convertirANumero(request.getEdadMenstruacion(), "edad_menstruacion"));
            response.setEdad_menopausia(convertirANumero(request.getEdadMenopausia(), "edad_menopausia"));
            response.setHormona_ER(convertirANumero(request.getHormonaER(), "hormona_ER"));
            response.setHormona_PR(convertirANumero(request.getHormonaPR(), "hormona_PR"));
            response.setHormona_HER2(convertirANumero(request.getHormonaHER2(), "hormona_HER2"));
            response.setSubtipo_molecular(convertirANumero(request.getSubtipoMolecular(), "subtipo_molecular"));
            response.setTamannio_tumor(request.getTamannioTumor());
            response.setEstructura_tubular(convertirANumero(request.getEstructuraTubular(),"tumor_tubular"));
            response.setCapaciadd_estado_miotico(convertirANumero(request.getCapacidadEstadoMiotico(),"capacidad_estado_miotico"));
            response.setEstructura_general(convertirANumero(request.getEstructuraGeneral(), "tumor_general"));
            response.setMutacion_BRCA1(convertirANumero(request.getMutacionBRCA1(), "mutacion_BRCA1"));
            response.setMutacion_BRCA2(convertirANumero(request.getMutacionBRCA2(), "mutacion_BRCA2"));
            response.setFamiliares_diagnosticados(request.getFamiliaresDiagnosticados());
            response.setRadioterapia_anterior(convertirANumero(request.getRadioterapiaAnterior(), "radioterapia_anterior"));
            response.setCancer_mama(convertirANumero(request.getCancerMama(), "cancer_mama"));
            response.setFechaRespuesta(LocalDateTime.now());
            return clinicFormRepository1.save(response);
    }

    private Integer convertirANumero(String valor, String categoria) {
        if (valor == null) return null;

        // Mapeo de las respuestas en el formulario a números
        Map<String, Integer> conversion = new HashMap<>();

        // Mapeo de edades
        conversion.put("Menos de 20 años", 0);
        conversion.put("21-30 años", 1);
        conversion.put("31 - 40 años", 2);
        conversion.put("41 - 50 años", 3);
        conversion.put("51 - 60 años", 4);
        conversion.put("61-70 años", 5);
        conversion.put("Más de 70 años", 6);

        // Mapeo de sexo
        conversion.put("Femenino", 1);
        conversion.put("Masculino", 0);

        // Mapeo de "Sí" y "No"
        conversion.put("Sí", 1);
        conversion.put("No", 0);

        // Mapeo de tipos de tratamiento
        conversion.put("Quimioterapia", 0);
        conversion.put("Radioterapia", 1);
        conversion.put("Cirugía", 2);
        conversion.put("Terapia hormonal", 3);
        conversion.put("Otros", 4);

        // Mapeo de la primera menstruación
        conversion.put("Antes de los 12 años", 0);
        conversion.put("Entre los 12-14 años", 1);
        conversion.put("Después de los 14 años", 2);

        // Mapeo de edad de la menopausia
        conversion.put("Antes de los 45 años", 0);
        conversion.put("Después de los 55 años", 1);


        // "No aplica" para ciertos valores: Se distingue por categorías
        if (categoria.equals("tipo_tratamiento")) {
            conversion.put("No aplica - tipo_tratamiento", 5);  // Para tipos de tratamiento
        } else if (categoria.equals("frecuencia_alcohol")) {
            conversion.put("No aplica - frecuencia_alcohol", 3);  // Para frecuencia de alcohol
        } else if (categoria.equals("edad_menopausia")) {
            conversion.put("No aplica - edad_menopausia", 2);  // Para edad de menopausia
        } else if (categoria.equals("hijos_lactancia")) {
            conversion.put("No aplica", 2);  // Para hijos lactancia
        } else if (categoria.equals("etnia")) {
            conversion.put("No aplica", 0 );
        } else if (categoria.equals("menopausia")) {
            conversion.put("No aplica", 2);
        }

        // Mapeo de actividad física
        conversion.put("1 vez a la semana", 0);
        conversion.put("2-3 veces a la semana", 1);
        conversion.put("4 o más", 2);

        // Mapeo de frecuencia de fumar
        conversion.put("Sí", 1);
        conversion.put("No", 0);


        // Mapeo de grasas saturadas
        conversion.put("Diario", 0);
        conversion.put("Varias veces a la semana", 1);
        conversion.put("Rara vez", 2);
        conversion.put("Nunca", 3);

        //Menopausia
        conversion.put("Pre", 0);
        conversion.put("Post", 1);

        //Etnia
        conversion.put("Blanco", 1);
        conversion.put("Negro", 2);
        conversion.put("Asiatico", 3);
        conversion.put("Nativo", 4);
        conversion.put("Hispanico", 5);
        conversion.put("Multi-hetnico",6);
        conversion.put("Hawaiano", 7);
        conversion.put("Indio-Americano", 8);

        conversion.put("Positivo", 1);
        conversion.put("Negativo", 0);
        conversion.put("Frontera", 2);

        conversion.put("Luminal-like", 0);
        conversion.put("ER_PR_HER2", 1);
        conversion.put("ER_positivo", 2);
        conversion.put("triple_negativo", 0);


        conversion.put("poca_diferencia", 0);
        conversion.put("diferencia_moderada", 1);
        conversion.put("gran_diferencia", 0);

        // Retorna el valor correspondiente
        return conversion.getOrDefault(valor, -1); // Si no encuentra el valor, devuelve -1
    }
}

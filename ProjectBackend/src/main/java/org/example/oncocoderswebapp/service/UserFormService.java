package org.example.oncocoderswebapp.service;

import org.example.oncocoderswebapp.model.User;
import org.example.oncocoderswebapp.model.UserFormResponse;
import org.example.oncocoderswebapp.repository.UserFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserFormService {

    @Autowired
    private UserFormRepository userFormRepository;

    public void save(User usuario, Map<String, String> respuestas) {
        UserFormResponse respuestaFormulario = new UserFormResponse();
        respuestaFormulario.setUsuario(usuario);
        respuestaFormulario.setFechaRespuesta(LocalDateTime.now());

        // Llamadas a convertirANumero pasando las categorías adecuadas
        respuestaFormulario.setEdad(convertirANumero(respuestas.get("edad"), "edad"));
        respuestaFormulario.setSexo(convertirANumero(respuestas.get("sexo"), "sexo"));
        respuestaFormulario.setBulto(convertirANumero(respuestas.get("bulto"), "bulto"));
        respuestaFormulario.setDolor_senos_axilas(convertirANumero(respuestas.get("dolor_senos_axilas"), "dolor_senos_axilas"));
        respuestaFormulario.setCambios_hinchazon_piel_senos(convertirANumero(respuestas.get("cambios_hinchazon_piel_senos"), "cambios_hinchazon_piel_senos"));
        respuestaFormulario.setPezones_rectacion_secrecion(convertirANumero(respuestas.get("pezones_rectacion_secrecion"), "pezones_rectacion_secrecion"));
        respuestaFormulario.setGanglios_inflamados_dolor(convertirANumero(respuestas.get("ganglios_inflamados_dolor"), "ganglios_inflamados_dolor"));
        respuestaFormulario.setPerdida_peso_inexplicada(convertirANumero(respuestas.get("perdida_peso_inexplicada"), "perdida_peso_inexplicada"));
        respuestaFormulario.setFatiga_persistente_cansancio_inexplicado(convertirANumero(respuestas.get("fatiga_persistente_cansancio_inexplicado"), "fatiga_persistente_cansancio_inexplicado"));
        respuestaFormulario.setFiebre_inexplicada(convertirANumero(respuestas.get("fiebre_inexplicada"), "fiebre_inexplicada"));
        respuestaFormulario.setHinchazon_brazos_manos(convertirANumero(respuestas.get("hinchazon_brazos_manos"), "hinchazon_brazos_manos"));
        respuestaFormulario.setDolor_huesos_articulaciones_inexplicado(convertirANumero(respuestas.get("dolor_huesos_articulaciones_inexplicado"), "dolor_huesos_articulaciones_inexplicado"));
        respuestaFormulario.setSudoracion_nocturna_excesiva(convertirANumero(respuestas.get("sudoracion_nocturna_excesiva"), "sudoracion_nocturna_excesiva"));
        respuestaFormulario.setDiagnostico_previo(convertirANumero(respuestas.get("diagnostico_previo"), "diagnostico_previo"));
        respuestaFormulario.setFamiliares_diagnosticados(convertirANumero(respuestas.get("familiares_diagnosticados"), "familiares_diagnosticados"));
        respuestaFormulario.setNum_familiares_diagnosticados(Integer.valueOf(respuestas.get("num_familiares_diagnosticados")));
        respuestaFormulario.setTratamiento_actualmente(convertirANumero(respuestas.get("tratamiento_actualmente"), "tratamiento_actualmente"));
        respuestaFormulario.setTipos_tratamiento(convertirANumero(respuestas.get("tipos_tratamiento"), "tipos_tratamiento"));
        respuestaFormulario.setPrimera_menstruacion(convertirANumero(respuestas.get("primera_menstruacion"), "primera_menstruacion"));
        respuestaFormulario.setEdad_menopausia(convertirANumero(respuestas.get("edad_menopausia"), "edad_menopausia"));
        respuestaFormulario.setHijos(convertirANumero(respuestas.get("hijos"), "hijos"));
        respuestaFormulario.setHijos_lactancia(convertirANumero(respuestas.get("hijos_lactancia"), "hijos_lactancia"));
        respuestaFormulario.setAnticonceptivos_hormonales_5(convertirANumero(respuestas.get("anticonceptivos_hormonales_5"), "anticonceptivos_hormonales_5"));
        respuestaFormulario.setTerapia_remplazo_hormonal_postmenopausia(convertirANumero(respuestas.get("terapia_remplazo_hormonal_postmenopausia"), "terapia_remplazo_hormonal_postmenopausia"));
        respuestaFormulario.setFrequencia_act_fisica(convertirANumero(respuestas.get("frequencia_act_fisica"), "frequencia_act_fisica"));
        respuestaFormulario.setFrecuencia_alcohol(convertirANumero(respuestas.get("frecuencia_alcohol"), "frecuencia_alcohol"));
        respuestaFormulario.setFumar(convertirANumero(respuestas.get("fumar"), "fumar"));
        respuestaFormulario.setSobrepeso_obesidad(convertirANumero(respuestas.get("sobrepeso_obesidad"), "sobrepeso_obesidad"));
        respuestaFormulario.setGrasas_saturadas(convertirANumero(respuestas.get("grasas_saturadas"), "grasas_saturadas"));
        respuestaFormulario.setGrasas_saludables(convertirANumero(respuestas.get("grasas_saludables"), "grasas_saludables"));
        respuestaFormulario.setFruta_verdura(convertirANumero(respuestas.get("fruta_verdura"), "fruta_verdura"));
        respuestaFormulario.setIncorporacion_fibra(convertirANumero(respuestas.get("incorporacion_fibra"), "incorporacion_fibra"));
        respuestaFormulario.setHipertension_diabtetes(convertirANumero(respuestas.get("hipertension_diabetes"), "hipertension_diabetes"));
        respuestaFormulario.setRadioterapia_pecho(convertirANumero(respuestas.get("radioterapia_pecho"), "radioterapia_pecho"));
        respuestaFormulario.setCancerMama(convertirANumero(respuestas.get("cancer_mama"), "cancer_mama"));

        // Guardar la respuesta del formulario en el repositorio
        userFormRepository.save(respuestaFormulario);
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
            conversion.put("No aplica", 5);  // Para tipos de tratamiento
        } else if (categoria.equals("frecuencia_alcohol")) {
            conversion.put("No aplica", 3);  // Para frecuencia de alcohol
        } else if (categoria.equals("edad_menopausia")) {
            conversion.put("No aplica", 2);  // Para edad de menopausia
        } else if (categoria.equals("hijos_lactancia")) {
            conversion.put("No aplica", 2);  // Para hijos lactancia
        }

        // Mapeo de actividad física
        conversion.put("1 vez a la semana", 0);
        conversion.put("2-4 veces a la semana", 1);
        conversion.put("4 o más", 2);

        // Mapeo de frecuencia de fumar
        conversion.put("Sí", 1);
        conversion.put("No", 0);


        // Mapeo de grasas saturadas
        conversion.put("Diario", 0);
        conversion.put("Varias veces a la semana", 1);
        conversion.put("Rara vez", 2);
        conversion.put("Nunca", 3);

        conversion.put("Ocasionalmente", 0);
        conversion.put("Semanal", 1);
        conversion.put("Diariamente", 2);



        // Retorna el valor correspondiente
        return conversion.getOrDefault(valor, -1); // Si no encuentra el valor, devuelve -1
    }

    public List<UserFormResponse> getResponses() {
        return userFormRepository.findAll(); // Este método obtiene todas las respuestas de la base de datos
    }
}

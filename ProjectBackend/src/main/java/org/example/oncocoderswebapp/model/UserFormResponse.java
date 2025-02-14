package org.example.oncocoderswebapp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "userResponse")
public class UserFormResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

    private LocalDateTime fechaRespuesta;

    private Integer edad;
    private Integer sexo;
    private Integer bulto;
    private Integer dolor_senos_axilas;
    private Integer cambios_hinchazon_piel_senos;
    private Integer pezones_rectacion_secrecion;
    private Integer ganglios_inflamados_dolor;
    private Integer perdida_peso_inexplicada;
    private Integer fatiga_persistente_cansancio_inexplicado;
    private Integer fiebre_inexplicada;
    private Integer hinchazon_brazos_manos;
    private Integer dolor_huesos_articulaciones_inexplicado;
    private Integer sudoracion_nocturna_excesiva;
    private Integer diagnostico_previo;
    private Integer familiares_diagnosticados;
    private Integer num_familiares_diagnosticados;
    private Integer tratamiento_actualmente;
    private Integer tipos_tratamiento;
    private Integer primera_menstruacion;
    private Integer edad_menopausia;
    private Integer hijos;
    private Integer hijos_lactancia;
    private Integer anticonceptivos_hormonales_5;
    private Integer terapia_remplazo_hormonal_postmenopausia;
    private Integer frequencia_act_fisica;
    private Integer frecuencia_alcohol;
    private Integer fumar;
    private Integer sobrepeso_obesidad;
    private Integer grasas_saturadas;
    private Integer grasas_saludables;
    private Integer fruta_verdura;
    private Integer incorporacion_fibra;
    private Integer hipertension_diabtetes;
    private Integer radioterapia_pecho;
    private Integer cancer_mama;

    public UserFormResponse(Long id, User usuario, LocalDateTime fechaRespuesta, Integer edad, Integer sexo, Integer bulto, Integer dolor_senos_axilas, Integer pezones_rectacion_secrecion, Integer cambios_hinchazon_piel_senos, Integer ganglios_inflamados_dolor, Integer perdida_peso_inexplicada, Integer fatiga_persistente_cansancio_inexplicado, Integer fiebre_inexplicada, Integer dolor_huesos_articulaciones_inexplicado, Integer hinchazon_brazos_manos, Integer sudoracion_nocturna_excesiva, Integer diagnostico_previo, Integer familiares_diagnosticados, Integer num_familiares_diagnosticados, Integer tratamiento_actualmente, Integer tipos_tratamiento, Integer primera_menstruacion, Integer edad_menopausia, Integer hijos, Integer hijos_lactancia, Integer anticonceptivos_hormonales_5, Integer terapia_remplazo_hormonal_postmenopausia, Integer frequencia_act_fisica, Integer radioterapia_pecho, Integer hipertension_diabtetes, Integer incorporacion_fibra, Integer fruta_verdura, Integer grasas_saludables, Integer grasas_saturadas, Integer sobrepeso_obesidad, Integer fumar, Integer frecuencia_alcohol,Integer cancer_mama) {
        this.id = id;
        this.usuario = usuario;
        this.fechaRespuesta = fechaRespuesta;
        this.edad = edad;
        this.sexo = sexo;
        this.bulto = bulto;
        this.dolor_senos_axilas = dolor_senos_axilas;
        this.pezones_rectacion_secrecion = pezones_rectacion_secrecion;
        this.cambios_hinchazon_piel_senos = cambios_hinchazon_piel_senos;
        this.ganglios_inflamados_dolor = ganglios_inflamados_dolor;
        this.perdida_peso_inexplicada = perdida_peso_inexplicada;
        this.fatiga_persistente_cansancio_inexplicado = fatiga_persistente_cansancio_inexplicado;
        this.fiebre_inexplicada = fiebre_inexplicada;
        this.dolor_huesos_articulaciones_inexplicado = dolor_huesos_articulaciones_inexplicado;
        this.hinchazon_brazos_manos = hinchazon_brazos_manos;
        this.sudoracion_nocturna_excesiva = sudoracion_nocturna_excesiva;
        this.diagnostico_previo = diagnostico_previo;
        this.familiares_diagnosticados = familiares_diagnosticados;
        this.num_familiares_diagnosticados = num_familiares_diagnosticados;
        this.tratamiento_actualmente = tratamiento_actualmente;
        this.tipos_tratamiento = tipos_tratamiento;
        this.primera_menstruacion = primera_menstruacion;
        this.edad_menopausia = edad_menopausia;
        this.hijos = hijos;
        this.hijos_lactancia = hijos_lactancia;
        this.anticonceptivos_hormonales_5 = anticonceptivos_hormonales_5;
        this.terapia_remplazo_hormonal_postmenopausia = terapia_remplazo_hormonal_postmenopausia;
        this.frequencia_act_fisica = frequencia_act_fisica;
        this.radioterapia_pecho = radioterapia_pecho;
        this.hipertension_diabtetes = hipertension_diabtetes;
        this.incorporacion_fibra = incorporacion_fibra;
        this.fruta_verdura = fruta_verdura;
        this.grasas_saludables = grasas_saludables;
        this.grasas_saturadas = grasas_saturadas;
        this.sobrepeso_obesidad = sobrepeso_obesidad;
        this.fumar = fumar;
        this.frecuencia_alcohol = frecuencia_alcohol;
        this.cancer_mama = cancer_mama;
    }

    public UserFormResponse() {
    }

    public Integer getPerdida_peso_inexplicada() {
        return perdida_peso_inexplicada;
    }

    public void setPerdida_peso_inexplicada(Integer perdida_peso_inexplicada) {
        this.perdida_peso_inexplicada = perdida_peso_inexplicada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(LocalDateTime fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public Integer getBulto() {
        return bulto;
    }

    public void setBulto(Integer bulto) {
        this.bulto = bulto;
    }

    public Integer getDolor_senos_axilas() {
        return dolor_senos_axilas;
    }

    public void setDolor_senos_axilas(Integer dolor_senos_axilas) {
        this.dolor_senos_axilas = dolor_senos_axilas;
    }

    public Integer getCambios_hinchazon_piel_senos() {
        return cambios_hinchazon_piel_senos;
    }

    public void setCambios_hinchazon_piel_senos(Integer cambios_hinchazon_piel_senos) {
        this.cambios_hinchazon_piel_senos = cambios_hinchazon_piel_senos;
    }

    public Integer getPezones_rectacion_secrecion() {
        return pezones_rectacion_secrecion;
    }

    public void setPezones_rectacion_secrecion(Integer pezones_rectacion_secrecion) {
        this.pezones_rectacion_secrecion = pezones_rectacion_secrecion;
    }

    public Integer getGanglios_inflamados_dolor() {
        return ganglios_inflamados_dolor;
    }

    public void setGanglios_inflamados_dolor(Integer ganglios_inflamados_dolor) {
        this.ganglios_inflamados_dolor = ganglios_inflamados_dolor;
    }

    public Integer getFatiga_persistente_cansancio_inexplicado() {
        return fatiga_persistente_cansancio_inexplicado;
    }

    public void setFatiga_persistente_cansancio_inexplicado(Integer fatiga_persistente_cansancio_inexplicado) {
        this.fatiga_persistente_cansancio_inexplicado = fatiga_persistente_cansancio_inexplicado;
    }

    public Integer getFiebre_inexplicada() {
        return fiebre_inexplicada;
    }

    public void setFiebre_inexplicada(Integer fiebre_inexplicada) {
        this.fiebre_inexplicada = fiebre_inexplicada;
    }

    public Integer getHinchazon_brazos_manos() {
        return hinchazon_brazos_manos;
    }

    public void setHinchazon_brazos_manos(Integer hinchazon_brazos_manos) {
        this.hinchazon_brazos_manos = hinchazon_brazos_manos;
    }

    public Integer getDolor_huesos_articulaciones_inexplicado() {
        return dolor_huesos_articulaciones_inexplicado;
    }

    public void setDolor_huesos_articulaciones_inexplicado(Integer dolor_huesos_articulaciones_inexplicado) {
        this.dolor_huesos_articulaciones_inexplicado = dolor_huesos_articulaciones_inexplicado;
    }

    public Integer getSudoracion_nocturna_excesiva() {
        return sudoracion_nocturna_excesiva;
    }

    public void setSudoracion_nocturna_excesiva(Integer sudoracion_nocturna_excesiva) {
        this.sudoracion_nocturna_excesiva = sudoracion_nocturna_excesiva;
    }

    public Integer getDiagnostico_previo() {
        return diagnostico_previo;
    }

    public void setDiagnostico_previo(Integer diagnostico_previo) {
        this.diagnostico_previo = diagnostico_previo;
    }

    public Integer getFamiliares_diagnosticados() {
        return familiares_diagnosticados;
    }

    public void setFamiliares_diagnosticados(Integer familiares_diagnosticados) {
        this.familiares_diagnosticados = familiares_diagnosticados;
    }

    public Integer getNum_familiares_diagnosticados() {
        return num_familiares_diagnosticados;
    }

    public void setNum_familiares_diagnosticados(Integer num_familiares_diagnosticados) {
        this.num_familiares_diagnosticados = num_familiares_diagnosticados;
    }

    public Integer getTratamiento_actualmente() {
        return tratamiento_actualmente;
    }

    public void setTratamiento_actualmente(Integer tratamiento_actualmente) {
        this.tratamiento_actualmente = tratamiento_actualmente;
    }

    public Integer getTipos_tratamiento() {
        return tipos_tratamiento;
    }

    public void setTipos_tratamiento(Integer tipos_tratamiento) {
        this.tipos_tratamiento = tipos_tratamiento;
    }

    public Integer getPrimera_menstruacion() {
        return primera_menstruacion;
    }

    public void setPrimera_menstruacion(Integer primera_menstruacion) {
        this.primera_menstruacion = primera_menstruacion;
    }

    public Integer getEdad_menopausia() {
        return edad_menopausia;
    }

    public void setEdad_menopausia(Integer edad_menopausia) {
        this.edad_menopausia = edad_menopausia;
    }

    public Integer getHijos() {
        return hijos;
    }

    public void setHijos(Integer hijos) {
        this.hijos = hijos;
    }

    public Integer getHijos_lactancia() {
        return hijos_lactancia;
    }

    public void setHijos_lactancia(Integer hijos_lactancia) {
        this.hijos_lactancia = hijos_lactancia;
    }

    public Integer getAnticonceptivos_hormonales_5() {
        return anticonceptivos_hormonales_5;
    }

    public void setAnticonceptivos_hormonales_5(Integer anticonceptivos_hormonales_5) {
        this.anticonceptivos_hormonales_5 = anticonceptivos_hormonales_5;
    }

    public Integer getTerapia_remplazo_hormonal_postmenopausia() {
        return terapia_remplazo_hormonal_postmenopausia;
    }

    public void setTerapia_remplazo_hormonal_postmenopausia(Integer terapia_remplazo_hormonal_postmenopausia) {
        this.terapia_remplazo_hormonal_postmenopausia = terapia_remplazo_hormonal_postmenopausia;
    }

    public Integer getFrequencia_act_fisica() {
        return frequencia_act_fisica;
    }

    public void setFrequencia_act_fisica(Integer frequencia_act_fisica) {
        this.frequencia_act_fisica = frequencia_act_fisica;
    }

    public Integer getFrecuencia_alcohol() {
        return frecuencia_alcohol;
    }

    public void setFrecuencia_alcohol(Integer frecuencia_alcohol) {
        this.frecuencia_alcohol = frecuencia_alcohol;
    }

    public Integer getFumar() {
        return fumar;
    }

    public void setFumar(Integer fumar) {
        this.fumar = fumar;
    }

    public Integer getSobrepeso_obesidad() {
        return sobrepeso_obesidad;
    }

    public void setSobrepeso_obesidad(Integer sobrepeso_obesidad) {
        this.sobrepeso_obesidad = sobrepeso_obesidad;
    }

    public Integer getGrasas_saturadas() {
        return grasas_saturadas;
    }

    public void setGrasas_saturadas(Integer grasas_saturadas) {
        this.grasas_saturadas = grasas_saturadas;
    }

    public Integer getGrasas_saludables() {
        return grasas_saludables;
    }

    public void setGrasas_saludables(Integer grasas_saludables) {
        this.grasas_saludables = grasas_saludables;
    }

    public Integer getFruta_verdura() {
        return fruta_verdura;
    }

    public void setFruta_verdura(Integer fruta_verdura) {
        this.fruta_verdura = fruta_verdura;
    }

    public Integer getIncorporacion_fibra() {
        return incorporacion_fibra;
    }

    public void setIncorporacion_fibra(Integer incorporacion_fibra) {
        this.incorporacion_fibra = incorporacion_fibra;
    }

    public Integer getHipertension_diabtetes() {
        return hipertension_diabtetes;
    }

    public void setHipertension_diabtetes(Integer hipertension_diabtetes) {
        this.hipertension_diabtetes = hipertension_diabtetes;
    }

    public Integer getRadioterapia_pecho() {
        return radioterapia_pecho;
    }

    public void setRadioterapia_pecho(Integer radioterapia_pecho) {
        this.radioterapia_pecho = radioterapia_pecho;
    }


    public double getUsuario_id() {
        return this.usuario.getId();
    }

    public void setCancerMama(Integer cm) {
        this.cancer_mama=cm;
    }

    public double getCancer_mama() {
        return this.cancer_mama;
    }
}

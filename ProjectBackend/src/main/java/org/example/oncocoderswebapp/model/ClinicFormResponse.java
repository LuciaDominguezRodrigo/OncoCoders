package org.example.oncocoderswebapp.model;


import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;


@Entity (name = "clinicResponse1")
public class ClinicFormResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)  // Nuevo campo para el paciente
    private User patientUser;



    private LocalDateTime fechaRespuesta;


    private Integer edad;
    private Integer etnia;
    private Integer edad_mesntruacion;
    private Integer edad_menopausia;
    private Integer hormona_ER;
    private Integer hormona_PR;
    private Integer hormona_HER2;
    private Integer subtipo_molecular;
    private Integer tamannio_tumor;
    private Integer estructura_tubular;
    private Integer capaciadd_estado_miotico;
    private Integer estructura_general;
    private Integer mutacion_BRCA1;
    private Integer mutacion_BRCA2;
    private Integer familiares_diagnosticados;
    private Integer radioterapia_anterior;
    private Integer cancer_mama;

    public ClinicFormResponse() {
    }


    public ClinicFormResponse( Long id, User patientUser, LocalDateTime fechaRespuesta, Integer edad,
                              Integer etnia, Integer edad_mesntruacion, Integer edad_menopausia, Integer hormona_ER,
                              Integer hormona_PR, Integer hormona_HER2, Integer subtipo_molecular, Integer tamannio_tumor,
                              Integer estructura_tubular, Integer capaciadd_estado_miotico, Integer estructura_general,
                              Integer mutacion_BRCA1, Integer mutacion_BRCA2, Integer familiares_diagnosticados, Integer radioterapia_anterior, Integer cancer_mama) {

        this.id = id;
        this.patientUser = patientUser;
        this.fechaRespuesta = fechaRespuesta;
        this.edad = edad;
        this.etnia = etnia;
        this.edad_mesntruacion = edad_mesntruacion;
        this.edad_menopausia = edad_menopausia;
        this.hormona_ER = hormona_ER;
        this.hormona_PR = hormona_PR;
        this.hormona_HER2 = hormona_HER2;
        this.subtipo_molecular = subtipo_molecular;
        this.tamannio_tumor = tamannio_tumor;
        this.estructura_tubular = estructura_tubular;
        this.capaciadd_estado_miotico = capaciadd_estado_miotico;
        this.estructura_general = estructura_general;
        this.mutacion_BRCA1 = mutacion_BRCA1;
        this.mutacion_BRCA2 = mutacion_BRCA2;
        this.familiares_diagnosticados = familiares_diagnosticados;
        this.radioterapia_anterior = radioterapia_anterior;
        this.cancer_mama = cancer_mama;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public void setPatientUser(User patientUser) {
        this.patientUser = patientUser;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setFechaRespuesta(LocalDateTime fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public void setEtnia(Integer etnia) {
        this.etnia = etnia;
    }

    public void setEdad_menopausia(Integer edad_menopausia) {
        this.edad_menopausia = edad_menopausia;
    }

    public void setEdad_mesntruacion(Integer edad_mesntruacion) {
        this.edad_mesntruacion = edad_mesntruacion;
    }

    public void setHormona_ER(Integer hormona_ER) {
        this.hormona_ER = hormona_ER;
    }

    public void setHormona_PR(Integer hormona_PR) {
        this.hormona_PR = hormona_PR;
    }

    public void setHormona_HER2(Integer hormona_HER2) {
        this.hormona_HER2 = hormona_HER2;
    }

    public void setSubtipo_molecular(Integer subtipo_molecular) {
        this.subtipo_molecular = subtipo_molecular;
    }

    public void setTamannio_tumor(Integer tamannio_tumor) {
        this.tamannio_tumor = tamannio_tumor;
    }

    public void setEstructura_tubular(Integer estructura_tubular) {
        this.estructura_tubular = estructura_tubular;
    }

    public void setCapaciadd_estado_miotico(Integer capaciadd_estado_miotico) {
        this.capaciadd_estado_miotico = capaciadd_estado_miotico;
    }

    public void setEstructura_general(Integer estructura_general) {
        this.estructura_general = estructura_general;
    }

    public void setMutacion_BRCA1(Integer mutacion_BRCA1) {
        this.mutacion_BRCA1 = mutacion_BRCA1;
    }

    public void setMutacion_BRCA2(Integer mutacion_BRCA2) {
        this.mutacion_BRCA2 = mutacion_BRCA2;
    }

    public void setFamiliares_diagnosticados(Integer familiares_diagnosticados) {
        this.familiares_diagnosticados = familiares_diagnosticados;
    }

    public void setRadioterapia_anterior(Integer radioterapia_anterior) {
        this.radioterapia_anterior = radioterapia_anterior;
    }

    public void setCancer_mama(Integer cancer_mama) {
        this.cancer_mama = cancer_mama;
    }

    public Long getId() {
        return id;
    }


    public User getPatientUser() {
        return patientUser;
    }

    public LocalDateTime getFechaRespuesta() {
        return fechaRespuesta;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getEtnia() {
        return etnia;
    }

    public Integer getEdad_mesntruacion() {
        return edad_mesntruacion;
    }

    public Integer getEdad_menopausia() {
        return edad_menopausia;
    }

    public Integer getHormona_ER() {
        return hormona_ER;
    }

    public Integer getHormona_PR() {
        return hormona_PR;
    }

    public Integer getHormona_HER2() {
        return hormona_HER2;
    }

    public Integer getSubtipo_molecular() {
        return subtipo_molecular;
    }

    public Integer getTamannio_tumor() {
        return tamannio_tumor;
    }

    public Integer getEstructura_tubular() {
        return estructura_tubular;
    }

    public Integer getCapaciadd_estado_miotico() {
        return capaciadd_estado_miotico;
    }

    public Integer getEstructura_general() {
        return estructura_general;
    }

    public Integer getMutacion_BRCA1() {
        return mutacion_BRCA1;
    }

    public Integer getMutacion_BRCA2() {
        return mutacion_BRCA2;
    }

    public Integer getFamiliares_diagnosticados() {
        return familiares_diagnosticados;
    }

    public Integer getRadioterapia_anterior() {
        return radioterapia_anterior;
    }

    public Integer getCancer_mama() {
        return cancer_mama;
    }
}


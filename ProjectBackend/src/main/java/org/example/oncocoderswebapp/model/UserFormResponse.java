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

    private String pregunta1;
    private String pregunta2;
    private String pregunta3;


    public UserFormResponse(Long id, LocalDateTime fechaRespuesta, String pregunta3, String pregunta2, String pregunta1, User usuario) {
        this.id = id;
        this.fechaRespuesta = fechaRespuesta;
        this.pregunta3 = pregunta3;
        this.pregunta2 = pregunta2;
        this.pregunta1 = pregunta1;
        this.usuario = usuario;
    }

    public UserFormResponse() {}

    private LocalDateTime fechaRespuesta;

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

    public String getPregunta1() {
        return pregunta1;
    }

    public void setPregunta1(String pregunta1) {
        this.pregunta1 = pregunta1;
    }

    public String getPregunta2() {
        return pregunta2;
    }

    public void setPregunta2(String pregunta2) {
        this.pregunta2 = pregunta2;
    }

    public LocalDateTime getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(LocalDateTime fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public String getPregunta3() {
        return pregunta3;
    }

    public void setPregunta3(String pregunta3) {
        this.pregunta3 = pregunta3;
    }


}

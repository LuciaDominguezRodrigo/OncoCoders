package org.example.oncocoderswebapp.model;


import jakarta.persistence.*;

@Entity (name ="diagnosis")
public class UserDiagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario; // Relación ManyToOne con Usuario

    private String modelo1;
    private String modelo2;
    private String modelo3;
    private String modelo4;// Nombre del diagnóstico (modelo 1, modelo 2, etc.)

    public UserDiagnosis() {}
    // Constructor, getters y setters


    public UserDiagnosis(User usuario, String modelo1, String modelo2, String modelo3, String modelo4) {
        this.usuario = usuario;
        this.modelo1 = modelo1;
        this.modelo2 = modelo2;
        this.modelo3 = modelo3;
        this.modelo4 = modelo4;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public void setModelo1(String modelo1) {
        this.modelo1 = modelo1;
    }

    public void setModelo2(String modelo2) {
        this.modelo2 = modelo2;
    }

    public void setModelo3(String modelo3) {
        this.modelo3 = modelo3;
    }

    public void setModelo4(String modelo4) {
        this.modelo4 = modelo4;
    }

    public Long getId() {
        return this.id;
    }

    public String getModelo4() {
        return modelo4;
    }

    public String getModelo3() {
        return modelo3;
    }

    public String getModelo2() {
        return modelo2;
    }

    public String getModelo1() {
        return modelo1;
    }

    public User getUsuario() {
        return usuario;
    }
}

package org.example.oncocoderswebapp.DTO;

public class UserRegisterDTO {
    private String name;
    private String email;
    private String password;
    private String role;
    private String comunidadAutonoma;  // Nuevo campo
    private String hospitalReferencia;
    private Boolean consentFirm;// Nuevo campo

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role.toUpperCase();
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Getters y setters para los nuevos campos
    public String getComunidadAutonoma() {
        return comunidadAutonoma;
    }

    public void setComunidadAutonoma(String comunidadAutonoma) {
        this.comunidadAutonoma = comunidadAutonoma;
    }

    public String getHospitalReferencia() {
        return hospitalReferencia;
    }

    public void setHospitalReferencia(String hospitalReferencia) {
        this.hospitalReferencia = hospitalReferencia;
    }

    public boolean isConsentFirm() {
        return consentFirm;
    }

    public void setConsentFirm(boolean consentFirm) {
        this.consentFirm = consentFirm;

    }
}

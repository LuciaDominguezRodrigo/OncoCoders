package org.example.oncocoderswebapp.DTO;


public class FormDTO {

    private String pregunta1;

    private String pregunta2;

    private String pregunta3;

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

    public String getPregunta3() {
        return pregunta3;
    }

    public void setPregunta3(String pregunta3) {
        this.pregunta3 = pregunta3;
    }

    // Constructor (opcional)
    public FormDTO(String pregunta1, String pregunta2, String pregunta3) {
        this.pregunta1 = pregunta1;
        this.pregunta2 = pregunta2;
        this.pregunta3 = pregunta3;
    }

    // Constructor vacío
    public FormDTO() {}
}

package br.com.zupacademy.beatriz.casadocodigo.validations;

public class ErrorHandlerDTO {

    private String field;
    private String error;

    public ErrorHandlerDTO(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}

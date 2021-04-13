package br.com.zupacademy.beatriz.casadocodigo.custormers;

import br.com.zupacademy.beatriz.casadocodigo.validations.anotations.ValidatesCPFOrCNPJ;

public class Teste {

    @ValidatesCPFOrCNPJ(message = "Valor está incorreto")
    private String document;

    public Teste(String document) {
        this.document = document;
    }


    public String getDocument() {
        return document;
    }


}

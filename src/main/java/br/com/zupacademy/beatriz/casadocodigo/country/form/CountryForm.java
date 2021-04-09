package br.com.zupacademy.beatriz.casadocodigo.country.form;

import br.com.zupacademy.beatriz.casadocodigo.country.Country;
import br.com.zupacademy.beatriz.casadocodigo.validations.anotations.UniqueValue;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CountryForm {

    @NotNull(message = "Nome de país é obrigatório")
    @UniqueValue(value = "name", className = Country.class, message = "País já cadastrado com esse nome")
    @NotEmpty(message = "Nome de país é obrigatório")
    private String name;

    public Country register () {
        return new Country(name);
    }

    public String getName() {
        return name;
    }
}

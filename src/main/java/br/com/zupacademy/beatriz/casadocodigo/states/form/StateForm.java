package br.com.zupacademy.beatriz.casadocodigo.states.form;

import br.com.zupacademy.beatriz.casadocodigo.country.Country;
import br.com.zupacademy.beatriz.casadocodigo.country.CountryRepository;
import br.com.zupacademy.beatriz.casadocodigo.states.State;
import br.com.zupacademy.beatriz.casadocodigo.validations.anotations.UniqueValue;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StateForm {

    @NotNull(message = "Nome do estado é obrigatório")
    @NotEmpty(message = "Nome do estado é obrigatório")
    @UniqueValue(value = "name", className = State.class, message = "Estado já cadastrado")
    private String name;

    @NotNull(message = "País é obrigatório")
    private Long countryId;

    public State register(CountryRepository countryRepository) {
        Country country = countryRepository.findById(countryId).get();
        return new State(name, country);
    }

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }
}

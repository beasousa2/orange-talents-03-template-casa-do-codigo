package br.com.zupacademy.beatriz.casadocodigo.states.dto;

import br.com.zupacademy.beatriz.casadocodigo.country.Country;
import br.com.zupacademy.beatriz.casadocodigo.states.State;

public class StateDTO {

    private Long id;
    private String name;
    private String country;
    private Country countryComplete;

    public StateDTO(State state) {
        this.id = state.getId();
        this.name = state.getName();
        this.country = state.getCountry().getName();
        //this.countryComplete = state.getCountry();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}

package br.com.zupacademy.beatriz.casadocodigo.states.dto;

import br.com.zupacademy.beatriz.casadocodigo.states.State;

public class StateDTO {

    private Long id;
    private String name;
    private String country;

    public StateDTO(State state) {
        this.id = state.getId();
        this.name = state.getName();
        this.country = state.getCountry().getName();
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

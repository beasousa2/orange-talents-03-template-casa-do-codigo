package br.com.zupacademy.beatriz.casadocodigo.country.dto;

import br.com.zupacademy.beatriz.casadocodigo.country.Country;

public class CountryDTO {

    private Long id;
    private String name;

    public CountryDTO(Country country) {
        this.id = country.getId();
        this.name = country.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

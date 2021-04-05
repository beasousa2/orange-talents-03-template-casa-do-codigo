package br.com.zupacademy.beatriz.casadocodigo.autor.dto;

import br.com.zupacademy.beatriz.casadocodigo.autor.Autor;

import java.time.LocalDateTime;

public class CompleteAutorDTO {

    private final Long id;
    private final String name;
    private final String email;
    private final String description;
    private final LocalDateTime registrationDate;

    public CompleteAutorDTO(Autor autor) {
        this.id = autor.getId();
        this.name = autor.getName();
        this.email = autor.getEmail();
        this.description = autor.getDescription();
        this.registrationDate = autor.getRegistrationDate();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
}

package br.com.zupacademy.beatriz.casadocodigo.category.dto;

import br.com.zupacademy.beatriz.casadocodigo.category.Category;

public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

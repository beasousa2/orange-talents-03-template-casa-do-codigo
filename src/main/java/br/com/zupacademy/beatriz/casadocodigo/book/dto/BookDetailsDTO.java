package br.com.zupacademy.beatriz.casadocodigo.book.dto;

import br.com.zupacademy.beatriz.casadocodigo.book.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookDetailsDTO {

    private Long id;
    private String title;

    public BookDetailsDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}

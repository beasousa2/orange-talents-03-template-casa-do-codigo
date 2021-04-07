package br.com.zupacademy.beatriz.casadocodigo.book.dto;

import br.com.zupacademy.beatriz.casadocodigo.autor.Autor;
import br.com.zupacademy.beatriz.casadocodigo.book.Book;
import br.com.zupacademy.beatriz.casadocodigo.category.Category;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class BookDTO {

    private Long id;
    private String title;
    private String bookAbstract;
    private String summary;
    private Double price;
    private Integer pagesNumber;
    private String isbn;
    private LocalDateTime publicationDate;
    private String category;
    private String autor;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.bookAbstract = book.getBookAbstract();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.pagesNumber = book.getPagesNumber();
        this.isbn = book.getIsbn();
        this.publicationDate = book.getPublicationDate();
        this.autor = book.getAutor().getName();
        this.category = book.getCategory().getName();

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBookAbstract() {
        return bookAbstract;
    }

    public String getSummary() {
        return summary;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getPagesNumber() {
        return pagesNumber;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategory() {
        return category;
    }




}

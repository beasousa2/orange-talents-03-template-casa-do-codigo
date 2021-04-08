package br.com.zupacademy.beatriz.casadocodigo.book.dto;

import br.com.zupacademy.beatriz.casadocodigo.book.Book;

public class CompleteBookDTO {


    private String title;
    private String bookAbstract;
    private String summary;
    private Double price;
    private Integer pagesNumber;
    private String isbn;
    private String autorDescription;
    private String autor;

    public CompleteBookDTO(Book book) {
        this.title = book.getTitle();
        this.bookAbstract = book.getBookAbstract();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.pagesNumber = book.getPagesNumber();
        this.isbn = book.getIsbn();
        this.autorDescription = book.getAutor().getDescription();
        this.autor = book.getAutor().getName();
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

    public String getAutorDescription() {
        return autorDescription;
    }

    public String getAutor() {
        return autor;
    }
}

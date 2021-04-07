package br.com.zupacademy.beatriz.casadocodigo.book;

import br.com.zupacademy.beatriz.casadocodigo.autor.Autor;
import br.com.zupacademy.beatriz.casadocodigo.category.Category;
import br.com.zupacademy.beatriz.casadocodigo.validations.anotations.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty(message = "Título é obrigatório")
    private String title;

    @NotNull
    @NotEmpty(message = "Resumo é obrigatório")
    @Length(max = 500)
    private String bookAbstract;

    private String summary;

    @NotNull(message = "Preço é obrigatório")
    @Min(value = 20)
    private Double price;

    @NotNull(message = "Número de páginas é obrigatório")
    @Min(value = 100)
    private Integer pagesNumber;

    @NotNull
    @NotEmpty(message = "Resumo é obrigatório")
    //@UniqueValue(value = "isbn", className = Book.class, message = "ISBN já cadastrado")
    private String isbn;

    @Future
    //@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publicationDate;

    @NotNull
    @ManyToOne
    private Autor autor;

    @NotNull
    @ManyToOne
    private Category category;

    @Deprecated
    public Book() { }

    public Book(String title,
                String bookAbstract,
                String summary,
                Double price,
                Integer pagesNumber,
                String isbn,
                LocalDate publicationDate,
                Autor autor,
                Category category) {
        this.title = title;
        this.bookAbstract = bookAbstract;
        this.summary = summary;
        this.price = price;
        this.pagesNumber = pagesNumber;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.autor = autor;
        this.category = category;
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

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public Autor getAutor() {
        return autor;
    }

    public Category getCategory() {
        return category;
    }
}

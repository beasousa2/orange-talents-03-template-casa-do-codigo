package br.com.zupacademy.beatriz.casadocodigo.book.form;

import br.com.zupacademy.beatriz.casadocodigo.autor.Autor;
import br.com.zupacademy.beatriz.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.beatriz.casadocodigo.book.Book;
import br.com.zupacademy.beatriz.casadocodigo.category.Category;
import br.com.zupacademy.beatriz.casadocodigo.category.CategoryRepository;
import br.com.zupacademy.beatriz.casadocodigo.validations.anotations.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class BookForm {

    @NotNull
    @NotEmpty(message = "Título é obrigatório")
    @UniqueValue(value = "title", className = Book.class, message = "Titulo precisa ser unico")
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
    @UniqueValue(value = "isbn", className = Book.class, message = "ISBN já cadastrado")
    private String isbn;

    @Future
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publicationDate;

    @NotNull(message = "Autor é obirgatório")
    private Long autorId;

    @NotNull(message = "Categoria é obrigatório")
    private Long categoryId;

    public Book register(AutorRepository autorRepository, CategoryRepository categoryRepository) {
        Autor autor = autorRepository.findById(autorId).get();
        Category category = categoryRepository.findById(categoryId).get();
        return new Book(title,
                        bookAbstract,
                        summary,
                        price,
                        pagesNumber,
                        isbn,
                        this.getPublicationDate(),
                        autor,
                        category);
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

    public LocalDate  getPublicationDate() {
        return publicationDate;
    }

    public Long getAutorId() {
        return autorId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    //somente para o JSON poder fazer o parse da data
    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
}

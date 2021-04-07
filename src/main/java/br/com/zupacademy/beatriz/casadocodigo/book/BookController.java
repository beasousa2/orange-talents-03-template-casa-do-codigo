package br.com.zupacademy.beatriz.casadocodigo.book;

import br.com.zupacademy.beatriz.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.beatriz.casadocodigo.book.dto.BookDTO;
import br.com.zupacademy.beatriz.casadocodigo.book.form.BookForm;
import br.com.zupacademy.beatriz.casadocodigo.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AutorRepository autorRepository;

    public void show() { }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> returnById(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(value -> ResponseEntity.ok(new BookDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<BookDTO> save(@RequestBody @Valid BookForm bookForm, UriComponentsBuilder uriBuilder) {
        Book book = bookForm.register(autorRepository, categoryRepository);

        bookRepository.save(book);

        URI uri = uriBuilder.path("/books/{id}").buildAndExpand(book.getId()).toUri();

        return ResponseEntity.created(uri).body(new BookDTO(book));
    }
}

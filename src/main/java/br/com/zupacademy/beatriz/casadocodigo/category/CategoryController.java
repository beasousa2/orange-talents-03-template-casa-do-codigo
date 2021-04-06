package br.com.zupacademy.beatriz.casadocodigo.category;

import br.com.zupacademy.beatriz.casadocodigo.category.dto.CategoryDTO;
import br.com.zupacademy.beatriz.casadocodigo.category.form.CategoryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;


    public void show() {
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(value -> ResponseEntity.ok(new CategoryDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategoryDTO> save(@RequestBody @Valid CategoryForm categoryForm, UriComponentsBuilder uriBuilder) {
        Category category = categoryForm.register();
        categoryRepository.save(category);

        URI uri = uriBuilder.path("/categories/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoryDTO(category));
    }
}

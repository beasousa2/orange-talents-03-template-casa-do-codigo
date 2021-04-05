package br.com.zupacademy.beatriz.casadocodigo.autor;

import br.com.zupacademy.beatriz.casadocodigo.autor.dto.CompleteAutorDTO;
import br.com.zupacademy.beatriz.casadocodigo.autor.form.AutorForm;
import br.com.zupacademy.beatriz.casadocodigo.validations.ExistingEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/autors")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @GetMapping
    public void show() {

    }

    @GetMapping("/{id}")
    public ResponseEntity<CompleteAutorDTO> returnAutorById(@PathVariable Long id) {
        Optional<Autor> autor = autorRepository.findById(id);
        return autor.map(value -> ResponseEntity.ok(new CompleteAutorDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CompleteAutorDTO> addNewAutor(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder) throws ExistingEmailException {

        Autor autor = autorForm.register();
        Autor existingAutor = autorRepository.findByEmail(autorForm.getEmail());
        if (existingAutor != null) {
            throw new ExistingEmailException(autor.getEmail());
        }

        autorRepository.save(autor);

        URI uri = uriBuilder.path("/autors/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new CompleteAutorDTO(autor));
    }
}

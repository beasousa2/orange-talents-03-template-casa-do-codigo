package br.com.zupacademy.beatriz.casadocodigo.country;

import br.com.zupacademy.beatriz.casadocodigo.book.Book;
import br.com.zupacademy.beatriz.casadocodigo.book.dto.BookDTO;
import br.com.zupacademy.beatriz.casadocodigo.country.dto.CountryDTO;
import br.com.zupacademy.beatriz.casadocodigo.country.form.CountryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("countries")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping
    public ResponseEntity<List<CountryDTO>> show() {
        List<Country> countryList = countryRepository.findAll();
        List<CountryDTO> countryDTOList = countryList.stream().map(CountryDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(countryDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> returnById(@PathVariable("id") Long id) {
        Optional<Country> country = countryRepository.findById(id);
        return country.map(value -> ResponseEntity.ok(new CountryDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CountryDTO> save(@RequestBody @Valid CountryForm countryForm, UriComponentsBuilder builder) {
        Country country = countryForm.register();
        countryRepository.save(country);
        URI uri = builder.path("/{id}").buildAndExpand(country.getId()).toUri();
        return ResponseEntity.created(uri).body(new CountryDTO(country));
    }
}

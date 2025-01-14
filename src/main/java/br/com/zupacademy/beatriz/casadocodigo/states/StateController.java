package br.com.zupacademy.beatriz.casadocodigo.states;

import br.com.zupacademy.beatriz.casadocodigo.country.CountryRepository;
import br.com.zupacademy.beatriz.casadocodigo.states.dto.StateDTO;
import br.com.zupacademy.beatriz.casadocodigo.states.form.StateForm;
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
@RequestMapping("states")
public class StateController {

    @Autowired
    StateRepository stateRepository;

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/{id}")
    public ResponseEntity<StateDTO> returnById(@PathVariable("id") Long id) {
        State state = stateRepository.findById(id).get();


        if (state != null) {
            return ResponseEntity.ok(new StateDTO(state));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("country/{id}")
    public ResponseEntity<List<StateDTO>> returnCountryById(@PathVariable("id") Long id) {
        List<State> state = stateRepository.findByCountry_Id(id);
        List<StateDTO> states = state.stream().map(StateDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok(states);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<StateDTO> save(@RequestBody @Valid StateForm stateForm, UriComponentsBuilder builder) {
        State state = stateForm.register(countryRepository);

        stateRepository.save(state);

        URI uri = builder.path("/{id}").buildAndExpand(state.getId()).toUri();
        return ResponseEntity.created(uri).body(new StateDTO(state));
    }
}

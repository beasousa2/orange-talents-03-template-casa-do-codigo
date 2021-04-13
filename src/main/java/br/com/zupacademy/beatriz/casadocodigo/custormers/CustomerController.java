package br.com.zupacademy.beatriz.casadocodigo.custormers;

import br.com.zupacademy.beatriz.casadocodigo.country.CountryRepository;
import br.com.zupacademy.beatriz.casadocodigo.custormers.dto.CustomerDTO;
import br.com.zupacademy.beatriz.casadocodigo.custormers.form.CustomerForm;

import br.com.zupacademy.beatriz.casadocodigo.states.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    StateRepository stateRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> returnById(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(value -> ResponseEntity.ok(new CustomerDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CustomerDTO> save(@RequestBody @Valid CustomerForm customerForm, UriComponentsBuilder builder) {
        Customer customer = customerForm.register(countryRepository, stateRepository);

        customerRepository.save(customer);

        URI uri = builder.path("customers/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(new CustomerDTO(customer));
    }


}

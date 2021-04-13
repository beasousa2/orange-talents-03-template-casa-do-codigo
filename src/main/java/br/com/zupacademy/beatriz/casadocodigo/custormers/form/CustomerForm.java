package br.com.zupacademy.beatriz.casadocodigo.custormers.form;

import br.com.zupacademy.beatriz.casadocodigo.country.Country;
import br.com.zupacademy.beatriz.casadocodigo.country.CountryRepository;
import br.com.zupacademy.beatriz.casadocodigo.custormers.Customer;
import br.com.zupacademy.beatriz.casadocodigo.states.State;
import br.com.zupacademy.beatriz.casadocodigo.states.StateRepository;
import br.com.zupacademy.beatriz.casadocodigo.validations.anotations.ValidatesCPFOrCNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;


public class CustomerForm {

    @NotNull
    @NotEmpty(message = "Nome é obrigatório")
    private String name;

    @NotNull
    @NotEmpty(message = "Sobrenome é obrigatório")
    private String lastname;

    @NotNull
    @NotEmpty(message = "Nome é obrigatório")
    @Email
    private String email;

    @NotNull
    @NotEmpty(message = "Documento é obrigatório")
    @ValidatesCPFOrCNPJ(message = "Número do documento inválido")
    private String customerDocument;

    @NotNull
    @NotEmpty(message = "Nome é obrigatório")
    private String zipCode;

    @NotNull
    @NotEmpty(message = "Nome é obrigatório")
    private String address;

    @NotNull
    @NotEmpty(message = "Nome é obrigatório")
    private String complement;

    @NotNull
    @NotEmpty(message = "Nome é obrigatório")
    private String city;

    @Null
    private Long stateId;

    @NotNull(message = "País é obrigatório")
    private Long countryId;

    @NotNull
    @NotEmpty(message = "Nome é obrigatório")
    private String phoneNumber;


    public Customer register(CountryRepository countryRepository, StateRepository stateRepository) {
        Country country = countryRepository.findById(countryId).get();
        List<State> stateList = stateRepository.findByCountry_Id(country.getId());
        State state;

        if (stateList.isEmpty() ) {
            state = null;
        } else {
            state = stateRepository.findById(stateId).get();
        }

        return new Customer(
                name,
                lastname,
                email,
                customerDocument,
                zipCode,
                address,
                complement,
                city,
                state,
                country,
                phoneNumber);
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getCustomerDocument() {
        return customerDocument;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public Long getStateId() {
        return stateId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

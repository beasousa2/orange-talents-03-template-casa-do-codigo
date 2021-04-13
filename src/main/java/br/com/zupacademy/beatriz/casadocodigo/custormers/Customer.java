package br.com.zupacademy.beatriz.casadocodigo.custormers;


import br.com.zupacademy.beatriz.casadocodigo.country.Country;
import br.com.zupacademy.beatriz.casadocodigo.states.State;
import br.com.zupacademy.beatriz.casadocodigo.validations.anotations.ValidatesCPFOrCNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @ValidatesCPFOrCNPJ
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
    @ManyToOne(fetch = FetchType.EAGER)
    private State state;

    @NotNull(message = "Nome é obrigatório")
    @ManyToOne
    private Country country;

    @NotNull
    @NotEmpty(message = "Nome é obrigatório")
    private String phoneNumber;

    @Deprecated
    public Customer() {}

    public Customer(String name,
                    String lastname,
                    String email,
                    String customerDocument,
                    String zipCode,
                    String address,
                    String complement,
                    String city,
                    State state,
                    Country country,
                    String phoneNumber) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.customerDocument = customerDocument;
        this.zipCode = zipCode;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String name, String lastname, String email, String customerDocument) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.customerDocument = customerDocument;

    }

    public Long getId() {
        return id;
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

    public State getState() {
        return state;
    }

    public Country getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

package br.com.zupacademy.beatriz.casadocodigo.custormers.dto;

import br.com.zupacademy.beatriz.casadocodigo.custormers.Customer;

import javax.validation.constraints.Null;

public class CustomerDTO {

    private String name;
    private String lastname;
    private String email;
    private String document;
    private String zipCode;
    private String address;
    private String complement;
    private String city;
    @Null
    private String state;
    private String country;
    private String phoneNumber;

    public CustomerDTO(Customer customer) {
        this.name = customer.getName();
        this.lastname = customer.getLastname();
        this.email = customer.getEmail();
        this.document = customer.getCustomerDocument();
        this.zipCode = customer.getZipCode();
        this.address = customer.getAddress();
        this.complement = customer.getComplement();
        this.city = customer.getCity();
        this.state = this.returnState(customer);
        this.country = customer.getCountry().getName();
        this.phoneNumber = customer.getPhoneNumber();
    }

    private String returnState(Customer customer) {
        if (customer.getState() == null) {
            return " ";
        } else {
            return customer.getState().getName();
        }
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

    public String getDocument() {
        return document;
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

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

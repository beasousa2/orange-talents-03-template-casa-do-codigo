package br.com.zupacademy.beatriz.casadocodigo.validations;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;

public class ExistingEmailException extends ServletRequestBindingException {

    @Deprecated
    public ExistingEmailException(String email) {
        super("Email já cadastrado: " + email);
    }
}

package br.com.zupacademy.beatriz.casadocodigo.validations;

import br.com.zupacademy.beatriz.casadocodigo.autor.Autor;
import br.com.zupacademy.beatriz.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.beatriz.casadocodigo.autor.form.AutorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ExistingAutorEmailValidator implements Validator {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if( errors.hasErrors()) {
            return;
        }

        AutorForm autorForm = (AutorForm) target;
        Autor existingAutor = autorRepository.findByEmail(autorForm.getEmail());

        if(existingAutor != null ) {
            errors.rejectValue("email", null, "Email já cadastrado. ");
        }

    }
}

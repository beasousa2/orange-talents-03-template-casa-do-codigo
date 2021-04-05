package br.com.zupacademy.beatriz.casadocodigo.autor.form;

import br.com.zupacademy.beatriz.casadocodigo.autor.Autor;
import br.com.zupacademy.beatriz.casadocodigo.autor.AutorRepository;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AutorForm {

    @Autowired
    AutorRepository autorRepository;

    @NotNull
    @NotEmpty(message = "Nome é obrigatorio!")
    private String name;

    @NotNull
    @NotEmpty(message = "E-mail é obrigatorio!")
    @Email(message = "E-mail precisa ser um tipo válido")
    private String email;

    @NotNull
    @NotEmpty(message = "Descrição é obrigatória!")
    @Length(max = 400, message = "Descrição não pode conter mais que 400 caracteres")
    private String description;

    public Autor register() {
        return new Autor(name, email, description);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

}

package br.com.zupacademy.beatriz.casadocodigo.category.form;

import br.com.zupacademy.beatriz.casadocodigo.category.Category;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class CategoryForm {

    @NotNull
    @NotEmpty(message = "O nome é obrigatório")
    @Length(min = 3)
    private String name;

    public Category register() {
        return  new Category(name);
    }

    public String getName() {
        return name;
    }
}

package br.com.zupacademy.beatriz.casadocodigo.validations.anotations;


import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@CPF(message = "Número do documento Inválido")
@CNPJ(message = "Número do documento Inválido")
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { })
@Repeatable(ValidatesCPFOrCNPJ.List.class)
@ConstraintComposition(CompositionType.OR)
public @interface ValidatesCPFOrCNPJ {

    String message() default "{br.com.zupacademy.beatriz.cadadocodigo.validations.ValidatesCPFOrCNPJ}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface List {
        ValidatesCPFOrCNPJ[] value();
    }
}

package br.com.zupacademy.beatriz.casadocodigo.validations.anotations;

import org.springframework.validation.annotation.Validated;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValueValidation.class)
@Repeatable(UniqueValue.List.class)
public @interface UniqueValue {
    String message() default "{br.com.zupacademy.beatriz.cadadocodigo.validations.ValueAlreadyExist}";
    String value();
    Class<?> className();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD})
    @interface List {
        UniqueValue[] value();
    }
}

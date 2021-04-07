package br.com.zupacademy.beatriz.casadocodigo.validations.anotations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidation implements ConstraintValidator<UniqueValue, Object> {

    private String attribute;
    private Class<?> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        attribute = constraintAnnotation.value();
        clazz = constraintAnnotation.className();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("SELECT 1 FROM "+ clazz.getName() + " WHERE " + attribute + " = :value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();

        if(list.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

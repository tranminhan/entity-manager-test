package jpa.validation;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;

public class EvenNumberConstraintTest {

    @Test
    public void test() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        EntityWithEvenNumber entityWithEvenNumber = new EntityWithEvenNumber();

        Set<ConstraintViolation<EntityWithEvenNumber>> violations = validator.validate(entityWithEvenNumber);
        assertTrue(violations.isEmpty());

        entityWithEvenNumber.setValue(10);
        violations = validator.validate(entityWithEvenNumber);
        assertTrue(violations.isEmpty());

        entityWithEvenNumber.setValue(11);
        violations = validator.validate(entityWithEvenNumber);
        assertFalse(violations.isEmpty());
        for (ConstraintViolation<EntityWithEvenNumber> v : violations) {
            System.out.println(ReflectionToStringBuilder.toString(v));
        }
    }

}

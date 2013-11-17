package jpa.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EvenNumberConstraint implements ConstraintValidator<Even, Integer> {
    boolean includeZero;

    public void initialize(Even constraintAnnotation) {
        this.includeZero = constraintAnnotation.includeZero();
    }

    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        if (value == 0) {
            return includeZero;
        }
        return value % 2 == 0;
    }

}

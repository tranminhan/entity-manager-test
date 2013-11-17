package jpa.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.ElementType;

@Constraint(validatedBy = { EvenNumberConstraint.class })
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Even {

    String message() default "Number must be even";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean includeZero() default true;
}

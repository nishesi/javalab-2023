package ru.itis.nishesi.microservices.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidPageableValidator.class)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPageable {
    String message() default "Invalid page parameters, required size <= {maxSize} and offset <= {maxOffset}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int maxSize() default 10;

    int maxOffset() default 1000;
}


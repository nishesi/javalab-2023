package ru.itis.nishesi.microservices.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.data.domain.Pageable;


public class ValidPageableValidator implements ConstraintValidator<ValidPageable, Pageable> {
    private int maxPageSize;
    private int maxOffset;
    @Override
    public void initialize(ValidPageable validPageable) {
        maxPageSize = validPageable.maxSize();
        maxOffset = validPageable.maxOffset();
    }

    @Override
    public boolean isValid(Pageable pageable, ConstraintValidatorContext context) {
        return pageable.getPageSize() <= maxPageSize && pageable.getOffset() <= maxOffset;
    }
}

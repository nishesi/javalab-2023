package ru.itis.nishesi.microservices.validation;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.itis.nishesi.microservices.validation.responses.ValidationErrorDto;
import ru.itis.nishesi.microservices.validation.responses.ValidationErrorsDto;

import java.util.List;

@RestControllerAdvice
public class ValidationAspect {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationErrorsDto> handleConstraintValidationException(ConstraintViolationException ex) {
        List<ValidationErrorDto> list = ex.getConstraintViolations().stream().map(constraintViolation -> {
            var error = ValidationErrorDto.builder();
            error.message(constraintViolation.getMessage());
            String path = constraintViolation.getPropertyPath().toString();
            error.object(path.substring(path.lastIndexOf('.')+1));
            return error.build();
        }).toList();

        return ResponseEntity.badRequest().body(new ValidationErrorsDto(list));
    }
}

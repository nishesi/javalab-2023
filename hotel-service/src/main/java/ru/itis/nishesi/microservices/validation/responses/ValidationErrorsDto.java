package ru.itis.nishesi.microservices.validation.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidationErrorsDto {
    private List<ValidationErrorDto> errors;
}

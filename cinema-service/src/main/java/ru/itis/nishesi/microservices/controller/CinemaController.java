package ru.itis.nishesi.microservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.nishesi.microservices.dto.CinemaDto;
import ru.itis.nishesi.microservices.service.CinemaService;
import ru.itis.nishesi.microservices.validation.ValidPageable;

@Validated
@RestController
@RequestMapping("/cinema")
@RequiredArgsConstructor
public class CinemaController {
    private final CinemaService cinemaService;

    @GetMapping
    ResponseEntity<?> getCinemas(@RequestParam String city,
                                 @ValidPageable @PageableDefault Pageable pageable) {
        Page<CinemaDto> cinemasInCity = cinemaService.getCinemasInCity(city, pageable);
        return ResponseEntity.ok(cinemasInCity);
    }
}

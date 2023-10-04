package ru.itis.nishesi.microservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.nishesi.microservices.dto.CinemaDto;
import ru.itis.nishesi.microservices.dto.HotelDto;
import ru.itis.nishesi.microservices.dto.InfoDto;
import ru.itis.nishesi.microservices.service.CinemaService;
import ru.itis.nishesi.microservices.service.HotelService;

@RestController
@RequestMapping("/cinema-and-hotel")
@RequiredArgsConstructor
public class ClientController {
    private final CinemaService cinemaService;
    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<?> getInfo(@RequestParam String city, @PageableDefault Pageable pageable) {
        Page<CinemaDto> cinemas = cinemaService.getCinemas(city, pageable);
        Page<HotelDto> hotels = hotelService.getHotels(city, pageable);
        return ResponseEntity.ok(new InfoDto(cinemas, hotels));
    }
}

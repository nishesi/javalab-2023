package ru.itis.nishesi.microservices.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.itis.nishesi.microservices.dto.CinemaDto;

public interface CinemaService {
    Page<CinemaDto> getCinemasInCity(String city, Pageable pageable);
}

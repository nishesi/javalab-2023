package ru.itis.nishesi.microservices.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.itis.nishesi.microservices.dto.HotelDto;

public interface HotelService {
    Page<HotelDto> getCinemasInCity(String city, Pageable pageable);
}

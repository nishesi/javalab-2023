package ru.itis.nishesi.microservices.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.nishesi.microservices.dto.HotelDto;

@FeignClient(name = "hotel-service", url = "${feign.hotel-service.url}")
public interface HotelService {
    @GetMapping(value = "/hotel", consumes = MediaType.APPLICATION_JSON_VALUE)
    Page<HotelDto> getHotels(@RequestParam String city, Pageable pageable);
}

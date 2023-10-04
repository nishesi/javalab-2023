package ru.itis.nishesi.microservices.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.nishesi.microservices.dto.CinemaDto;

@FeignClient(name="cinema-service", url = "${feign.cinema-service.url}")
public interface CinemaService {
    @GetMapping(value = "/cinema", consumes = MediaType.APPLICATION_JSON_VALUE)
    Page<CinemaDto> getCinemas(@RequestParam String city, Pageable pageable);
}

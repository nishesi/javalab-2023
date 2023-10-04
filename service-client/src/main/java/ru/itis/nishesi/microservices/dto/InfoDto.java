package ru.itis.nishesi.microservices.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoDto {
    Page<CinemaDto> cinemaPage;
    Page<HotelDto> hotelPage;
}

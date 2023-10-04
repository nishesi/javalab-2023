package ru.itis.nishesi.microservices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto {
    private String type;
    private Properties properties;
    private Geometry geometry;

    @Data
    public static class Properties {
        private CompanyMetaData CompanyMetaData;
        private String description;
        private String name;

        @Data
        public static class CompanyMetaData {
            private Long id;
            private String name;
            private String address;
            private String url;
            private Phone[] phones;

            @Data
            public static class Phone {
                private String type;
                private String formatted;
            }
        }
    }

    @Data
    public static class Geometry {
        private String type;
        private Double[] coordinates;
    }
}

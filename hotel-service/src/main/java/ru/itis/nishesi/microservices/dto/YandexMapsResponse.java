package ru.itis.nishesi.microservices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class YandexMapsResponse<T> {
    private String type;
    private Properties properties;
    private List<T> features;

    @Data
    public static class Properties {
        private ResponseMetaData ResponseMetaData;

        @Data
        public static class ResponseMetaData {
            private SearchRequest SearchRequest;
            private SearchResponse SearchResponse;

            @Data
            public static class SearchRequest {
                private String request;
                private Integer results;
                private Integer skip;
            }

            @Data
            public static class SearchResponse {
                private Integer found;
            }
        }
    }
}

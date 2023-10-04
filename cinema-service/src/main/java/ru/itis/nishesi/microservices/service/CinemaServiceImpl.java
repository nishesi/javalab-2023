package ru.itis.nishesi.microservices.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.itis.nishesi.microservices.dto.CinemaDto;
import ru.itis.nishesi.microservices.dto.YandexMapsResponse;

import java.io.IOException;

@Service
public class CinemaServiceImpl implements CinemaService {
    private final OkHttpClient httpClient;
    private final HttpUrl url;
    private final ObjectMapper objectMapper;

    public CinemaServiceImpl(OkHttpClient httpClient,
                             ObjectMapper objectMapper,
                             @Value("${app.yandex-maps.apikey}") String apikey) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
        url = HttpUrl.get("https://search-maps.yandex.ru/v1/").newBuilder()
                .addQueryParameter("apikey", apikey)
                .addQueryParameter("lang", "ru_RU")
                .addQueryParameter("type", "biz")
                .build();
    }

    @Override
    public Page<CinemaDto> getCinemasInCity(String city, Pageable pageable) {
        String text = "кинотеатры, " + city;

        Request.Builder request = new Request.Builder();
        request.setUrl$okhttp(url.newBuilder().addQueryParameter("text", text).build());
        Call call = httpClient.newCall(request.build());

        YandexMapsResponse<CinemaDto> resp = parseResponse(call, new TypeReference<>() {
        });
        int total = resp.getProperties().getResponseMetaData().getSearchResponse().getFound();
        return new PageImpl<>(resp.getFeatures(), pageable, total);
    }

    private <T> T parseResponse(Call call, TypeReference<T> tTypeReference) {
        try (Response response = call.execute()) {
            String str = response.body().string();
            return objectMapper.readValue(str, tTypeReference);
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("Unknown error", e);
        }
    }
}

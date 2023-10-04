package ru.itis.nishesi.microservices;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CinemaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaServiceApplication.class, args);
	}

	@Bean
	ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.disable(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES);
		objectMapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		return objectMapper;
	}

	@Bean
	OkHttpClient httpClient() {
		return new OkHttpClient();
	}
}

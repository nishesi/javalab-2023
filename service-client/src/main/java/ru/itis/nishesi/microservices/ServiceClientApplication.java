package ru.itis.nishesi.microservices;

import com.fasterxml.jackson.databind.Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.PageJacksonModule;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class ServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceClientApplication.class, args);
	}
}

package io.github.igorcossta.microservice1;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class Microservice1Application {

    @GetMapping("/")
    @CircuitBreaker(name = "microservice1-method", fallbackMethod = "microservice1FB")
    public List<String> microservice1() {
        String url = "http://localhost:8082/microservice2";
        return restTemplate().getForObject(url, ArrayList.class);
    }

    public List<String> microservice1FB(Exception e) {
        return List.of("Something went wrong. Try later!");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Microservice1Application.class, args);
    }

}

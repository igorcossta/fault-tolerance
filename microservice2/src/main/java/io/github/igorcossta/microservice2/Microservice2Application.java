package io.github.igorcossta.microservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Microservice2Application {

    public static List<String> data = List.of("micro service 2", "called from", "micro service 1", "!");

    @GetMapping("/microservice2")
    public List<String> microservice2() {
        return data;
    }

    public static void main(String[] args) {
        SpringApplication.run(Microservice2Application.class, args);
    }

}

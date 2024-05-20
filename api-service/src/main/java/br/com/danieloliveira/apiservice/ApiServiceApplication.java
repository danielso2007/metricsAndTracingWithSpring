package br.com.danieloliveira.apiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ApiServiceApplication {

    public static void main(String[] args) {
        log.info("starting server");
        SpringApplication.run(ApiServiceApplication.class, args);
    }

}

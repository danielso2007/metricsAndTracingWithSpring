package br.com.danieloliveira.apiclient;

import java.time.Duration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import br.com.danieloliveira.apiclient.client.AvailabilityClient;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@SpringBootApplication
public class ApiClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiClientApplication.class, args);
    }

    @Bean
    WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> ready(AvailabilityClient client) {
        return applicationReadyEvent -> {
            for (var console : "ps5,xbox,ps4,switch".split(",")) {
                Flux.range(0, 20).delayElements(Duration.ofMillis(100)).subscribe(i -> client
                        .checkAvailability(console)
                        .subscribe(availability -> log.info("console: {}, availability: {} ", console,
                                availability.isAvailable())));
            }
        };
    }

}




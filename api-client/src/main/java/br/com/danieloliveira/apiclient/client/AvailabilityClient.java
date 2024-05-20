package br.com.danieloliveira.apiclient.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import br.com.danieloliveira.apiclient.availability.Availability;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AvailabilityClient {

    private final WebClient webClient;
    @Value("${availability.client.path}")
    private String path;
    @Value("${availability.client.url}")
    private String url;

    public Mono<Availability> checkAvailability(String console) {
        return this.webClient
                .get()
                .uri(url + path, console)
                .retrieve()
                .bodyToMono(Availability.class)
                .onErrorReturn(new Availability(false, console));
    }

}

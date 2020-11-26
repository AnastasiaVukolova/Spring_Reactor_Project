package org.spring.reactor.card.fines.client;

import org.spring.reactor.card.fines.client.dto.FineDTO;
import org.spring.reactor.card.fines.client.dto.FinesResponse;
import org.spring.reactor.card.fines.entity.FineType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EGovClient {

    private final static Random rnd = new Random();

    private final RestTemplate restTemplate;
    private final String baseURL;
    private final WebClient client;
    public EGovClient(@Value("${fines.egovURL}") String baseURL) {
        restTemplate = new RestTemplate();
        this.baseURL = baseURL;
        client = WebClient.create(baseURL);
    }



    public Mono<List<FineDTO>> getFines(String userId) {
        try {
            Thread.sleep(3000);  // todo add here randome sleep value

        return client.get()
                .uri(uriBuilder -> uriBuilder.path("/fines").queryParam("userId",userId).build())
                .exchange()
                .flatMap(res -> res.bodyToMono(FinesResponse.class));
        } catch (InterruptedException e) {
            return Mono.just(new ArrayList());
        }
    }


    public List<FineDTO> getFinesBasic(String userId) {
        try {
            Thread.sleep(3000);  // todo add here randome sleep value

            return restTemplate.getForObject(baseURL + "/fines?userId={userId}", FinesResponse.class, userId);
        } catch (InterruptedException e) {
            return new ArrayList();
        }
    }
}

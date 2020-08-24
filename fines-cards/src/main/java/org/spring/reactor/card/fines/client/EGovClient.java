package org.spring.reactor.card.fines.client;

import org.spring.reactor.card.fines.client.dto.FineDTO;
import org.spring.reactor.card.fines.entity.FineType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
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

    public EGovClient(@Value("${fines.egovURL}") String baseURL) {
    }

    public List<FineDTO> defineAdvices(String userId) {
        final List<FineDTO> cardStream = IntStream.range(0, 5)
                .mapToObj(ind -> FineDTO.builder()
                        .amount(BigDecimal.valueOf(rnd.nextLong()))
                        .fineType(FineType.fromInt(rnd.nextInt(FineType.values().length - 1)))
                        .id(UUID.randomUUID().toString())
                        .amount(new BigDecimal(ind * rnd.nextInt(10)))
                        .build()).collect(Collectors.toList());
        return cardStream;
    }

    public Mono<List<FineDTO>> getFines(String userId) {

        try {
            Thread.sleep(5000);  // todo add here randome sleep value

            return Mono.just(defineAdvices(userId));
        } catch (InterruptedException e) {
            return Mono.just(new ArrayList());
        }
    }
}

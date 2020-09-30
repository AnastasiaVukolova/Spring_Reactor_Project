package org.spring.reactor.card.fines.service;

import lombok.RequiredArgsConstructor;
import org.spring.reactor.card.entity.CardType;
import org.spring.reactor.card.entity.UserData;
import org.spring.reactor.card.fines.client.EGovClient;
import org.spring.reactor.card.fines.configuration.FinesProperties;
import org.spring.reactor.card.fines.entity.FineCard;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RemoteFinesService implements FinesService {
    private final static Random rnd = new Random();
    private final FinesProperties properties;
    private final EGovClient eGovClient;

    @Override
    public Flux<FineCard> loadFines(UserData userData) {
        return eGovClient.getFines(userData.getUserId())
                .flatMapIterable(res -> res)
                .map(fine ->
                        FineCard.builder()
                                .userId(userData.getUserId())
                                .dueDate(fine.getDueDate().getTime())
                                .amount(fine.getAmount())
                                .fineType(fine.getFineType())
                                .id(fine.getId())
                                .executionUrl(properties.getExecuteUrl())
                                .type(CardType.FINES)
                                .build());
    }

    @Override
    public List<FineCard> loadFinesBasic(UserData userData) {
        return eGovClient.getFinesBasic(userData.getUserId()).stream()
                .map(fine ->
                        FineCard.builder()
                                .userId(userData.getUserId())
                                .dueDate(fine.getDueDate().getTime())
                                .amount(fine.getAmount())
                                .fineType(fine.getFineType())
                                .id(fine.getId())
                                .executionUrl(properties.getExecuteUrl())
                                .type(CardType.FINES)
                                .build()
                ).collect(Collectors.toList());
    }
}

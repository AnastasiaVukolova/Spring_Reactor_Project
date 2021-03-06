package org.spring.reactor.card.advice.service;

import lombok.RequiredArgsConstructor;
import org.spring.reactor.card.advice.configuration.AdviceProperties;
import org.spring.reactor.card.advice.entity.AdviceCard;
import org.spring.reactor.card.advice.entity.AdviceType;
import org.spring.reactor.card.entity.CardType;
import org.spring.reactor.card.entity.UserData;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AIAdviceService implements AdviceService {
    private final static Random rnd = new Random();
    private final AdviceProperties adviseProperties;

    @Override
    public Flux<AdviceCard> defineAdvices(UserData userData) {
        final Stream<AdviceCard> cardStream = IntStream.range(0, 10)
                .mapToObj(ind -> AdviceCard.builder()
                        .userId(userData.getUserId())
                        .amount(BigDecimal.valueOf(rnd.nextLong()))
                        .adviceType(AdviceType.fromInt(rnd.nextInt(AdviceType.values().length - 1)))
                        .id(UUID.randomUUID().toString())
                        .executionUrl(adviseProperties.getExecuteUrl())
                        .type(CardType.ADVISE)
                        .build());
        return Flux.fromStream(cardStream);
    }

    @Override
    public List<AdviceCard> defineAdvicesBasic(UserData userData) {
        return IntStream.range(0, 10)
                .mapToObj(ind -> AdviceCard.builder()
                        .userId(userData.getUserId())
                        .amount(BigDecimal.valueOf(rnd.nextLong()))
                        .adviceType(AdviceType.fromInt(rnd.nextInt(AdviceType.values().length - 1)))
                        .id(UUID.randomUUID().toString())
                        .executionUrl(adviseProperties.getExecuteUrl())
                        .type(CardType.ADVISE)
                        .build())
                .collect(Collectors.toList());
    }
}

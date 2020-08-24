package org.spring.reactor.card.regular.service;

import lombok.RequiredArgsConstructor;
import org.spring.reactor.card.entity.CardType;
import org.spring.reactor.card.entity.UserData;
import org.spring.reactor.card.regular.configuration.RegularProperties;
import org.spring.reactor.card.regular.entity.RegularCard;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PersistenceRegularService implements RegularService {
    private static final long DAY = 86_400_000;
    private final RegularProperties properties;

    @Override
    public Flux<RegularCard> loadRegular(UserData userData) {
        Date from = new Date(userData.getCurrentDate() - DAY);
        Date to = new Date(userData.getCurrentDate() + DAY);
        Flux<RegularCard> cards = Flux.just(readCard(userData));
        return cards;
    }

    private RegularCard readCard(UserData userData) {

        RegularCard.builder()
                .userId(userData.getUserId())
                .dueDate(doc.getDueDate().getTime())
                .amount(doc.getAmount())
                .targetAccount(doc.getTargetAccount())
                .id(doc.getId())
                .executionUrl(properties.getExecuteUrl())
                .type(CardType.REGULAR)
                .build()
        );
    }
}

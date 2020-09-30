package org.spring.reactor.card.hub.client;


import org.spring.reactor.card.entity.Card;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.List;

public interface CardClient<T extends Card> {
    Flux<T> getCards(String userId,
                     BigDecimal longitude,
                     BigDecimal latitude,
                     Long currentDate);

    List<T> getCardsBasic(String userId,
                          BigDecimal longitude,
                          BigDecimal latitude,
                          Long currentDate);
}

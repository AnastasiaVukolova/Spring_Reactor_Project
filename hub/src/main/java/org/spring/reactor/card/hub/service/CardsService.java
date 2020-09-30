package org.spring.reactor.card.hub.service;

import org.spring.reactor.card.entity.Card;
import org.spring.reactor.card.entity.UserData;
import reactor.core.publisher.Flux;
import java.util.List;

public interface CardsService {
    Flux<Card> loadCards(UserData userData);

    List<Card> loadCardsBasic(UserData userData);
}

package org.spring.reactor.card.fines.service;

import org.spring.reactor.card.entity.UserData;
import org.spring.reactor.card.fines.entity.FineCard;
import reactor.core.publisher.Flux;

public interface FinesService {
    Flux<FineCard> loadFines(UserData userData);
}

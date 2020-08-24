package org.spring.reactor.card.regular.service;

import org.spring.reactor.card.entity.UserData;
import org.spring.reactor.card.regular.entity.RegularCard;
import reactor.core.publisher.Flux;

public interface RegularService {
    Flux<RegularCard> loadRegular(UserData userData);
}

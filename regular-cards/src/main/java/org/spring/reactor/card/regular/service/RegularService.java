package org.spring.reactor.card.regular.service;

import org.spring.reactor.card.entity.UserData;
import org.spring.reactor.card.regular.entity.RegularCard;
import reactor.core.publisher.Flux;

import java.util.List;

public interface RegularService {
    Flux<RegularCard> loadRegular(UserData userData);

    List<RegularCard> loadRegularBasic(UserData userData);

}

package org.spring.reactor.card.advice.service;

import org.spring.reactor.card.advice.entity.AdviceCard;
import org.spring.reactor.card.entity.UserData;
import reactor.core.publisher.Flux;

public interface AdviceService {
    Flux<AdviceCard> defineAdvices(UserData userData);
}

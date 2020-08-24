package org.spring.reactor.card.hub.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.reactor.card.entity.Card;
import org.spring.reactor.card.entity.UserData;
import org.spring.reactor.card.hub.client.AdviceCardClient;
import org.spring.reactor.card.hub.client.CardClient;
import org.spring.reactor.card.hub.client.FinesCardClient;
import org.spring.reactor.card.hub.client.RegularCardClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RemoteCardsHubService implements CardsService {
    private final List<CardClient> cardClients;

    private FinesCardClient finesCardClient;
    private AdviceCardClient adviceCardClient;
    private RegularCardClient regularCardClient;
    @Override
    public Flux<Card> loadCards(UserData userData) {

        final List<Flux<Card>> fluxList = cardClients.stream()
                .map(client -> getCards(userData, client))
                .collect(Collectors.toList());
        return Flux.merge(fluxList);
    }

    @SuppressWarnings("unchecked")
    private Flux<Card> getCards(UserData userData, CardClient client) {
        return client.getCards(userData.getUserId(),
                userData.getGeoPosition().getLongitude(), userData.getGeoPosition().getLatitude(),
                userData.getCurrentDate())
                .onErrorResume(err -> Flux.empty())
                .take(Duration.ofSeconds(6));
    }
}

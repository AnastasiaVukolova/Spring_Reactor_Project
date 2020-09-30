package org.spring.reactor.card.hub.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.reactor.card.entity.Card;
import org.spring.reactor.card.entity.UserData;
import org.spring.reactor.card.hub.client.CardClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RemoteCardsHubService implements CardsService {
    private final List<CardClient> cardClients;

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

    @Override
    public List<Card> loadCardsBasic(UserData userData) {
        return cardClients.stream()
                .parallel()
                .flatMap(client -> getCardsBasic(userData, client).stream())
                .collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    private List<Card> getCardsBasic(UserData userData, CardClient client) {
        try {
            return client.getCardsBasic(userData.getUserId(),
                    userData.getGeoPosition().getLongitude(), userData.getGeoPosition().getLatitude(),
                    userData.getCurrentDate());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}

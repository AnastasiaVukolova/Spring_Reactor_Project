package org.spring.reactor.card.regular.service;

import lombok.RequiredArgsConstructor;
import org.spring.reactor.card.entity.CardType;
import org.spring.reactor.card.entity.UserData;
import org.spring.reactor.card.regular.configuration.RegularProperties;
import org.spring.reactor.card.regular.entity.RegularCard;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersistenceRegularService implements RegularService {
    private static final long DAY = 86_400_000;
    private final RegularProperties properties;

    private static Flux<String> fromPath(Path path) {
        return Flux.using(() -> Files.lines(path),
                Flux::fromStream,
                BaseStream::close
        );
    }

    private RegularCard lineToCard(String line, UserData userData) {
        String[] arr = line.split(" ");
        RegularCard regularCard = new RegularCard();
        regularCard.setId(arr[0]);
        regularCard.setUserId(userData.getUserId());
        regularCard.setType(CardType.REGULAR);
        regularCard.setDueDate(arr[1]);
        regularCard.setAmount(new BigDecimal(arr[2]));
        regularCard.setTargetAccount(arr[3]);
        return regularCard;
    }

    @Override
    public Flux<RegularCard> loadRegular(UserData userData) {

        return fromPath(Paths.get(properties.getPath())).
                map(s -> lineToCard(s, userData));
    }

    @Override
    public List<RegularCard> loadRegularBasic(UserData userData) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(properties.getPath()));
            return allLines.stream().
                    map(s -> lineToCard(s, userData)).collect(Collectors.toList());

        } catch (IOException ioe) {
            System.out.println("Error reading file. " + ioe.getLocalizedMessage());
            return new ArrayList<>();
        }
    }
}

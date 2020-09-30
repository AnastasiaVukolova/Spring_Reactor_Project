package org.spring.reactor.card.regular.service;

import lombok.RequiredArgsConstructor;
import org.spring.reactor.card.entity.CardType;
import org.spring.reactor.card.entity.UserData;
import org.spring.reactor.card.regular.configuration.RegularProperties;
import org.spring.reactor.card.regular.entity.RegularCard;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.stream.BaseStream;

@Service
@RequiredArgsConstructor
public class PersistenceRegularService implements RegularService {
    private static final long DAY = 86_400_000;
    private final RegularProperties properties;

    @Override
    public Flux<RegularCard> loadRegular(UserData userData) {
        Date from = new Date(userData.getCurrentDate() - DAY);
        Date to = new Date(userData.getCurrentDate() + DAY);




       //Flux<RegularCard> cards = Flux.just(readCard(userData));

        return readCards(userData, Paths.get(properties.getPath()));
    }


    private Flux<RegularCard> readCards(UserData userData, Path path)
    {

        return fromPath(path).
        map(s -> {
            String[] arr = s.split(" ");
            RegularCard regularCard = new RegularCard();
            regularCard.setId(arr[0]);
            regularCard.setUserId(userData.getUserId());
            regularCard.setType(CardType.REGULAR);
            regularCard.setDueDate(arr[1]);
            regularCard.setAmount(new BigDecimal(arr[2]));
            regularCard.setTargetAccount(arr[3]);


            return regularCard;
        });
    }



	private static Flux<String> fromPath(Path path) {
		return Flux.using(() -> Files.lines(path),
				Flux::fromStream,
				BaseStream::close
		);
	}


//    private RegularCard readCard(UserData userData) {
//
//
//
////        RegularCard.builder()
////                .userId(userData.getUserId())
////                .dueDate(doc.getDueDate().getTime())
////                .amount(doc.getAmount())
////                .targetAccount(doc.getTargetAccount())
////                .id(doc.getId())
////                .executionUrl(properties.getExecuteUrl())
////                .type(CardType.REGULAR)
////                .build());
//    }
}

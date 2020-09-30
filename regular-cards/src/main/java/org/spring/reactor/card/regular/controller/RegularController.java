package org.spring.reactor.card.regular.controller;

import lombok.RequiredArgsConstructor;
import org.spring.reactor.card.entity.UserData;
import org.spring.reactor.card.regular.entity.RegularCard;
import org.spring.reactor.card.regular.service.RegularService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class RegularController {
    private final RegularService regularService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<RegularCard> loadRegular(@RequestHeader("userId") String userId,
                                         @RequestParam("currentDate") Long currentDate) {
        return regularService.loadRegular(UserData.builder()
                .currentDate(currentDate)
                .userId(userId)
                .build())
                .log();
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/basic", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RegularCard> loadRegularBasic(@RequestHeader("userId") String userId,
                                         @RequestParam("currentDate") Long currentDate) {
        return regularService.loadRegularBasic(UserData.builder()
                .currentDate(currentDate)
                .userId(userId)
                .build());
    }

}

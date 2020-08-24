package org.spring.reactor.card.fines.controller;

import lombok.RequiredArgsConstructor;
import org.spring.reactor.card.entity.UserData;
import org.spring.reactor.card.fines.entity.FineCard;
import org.spring.reactor.card.fines.service.FinesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class FinesController {
    private final FinesService finesService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<FineCard> loadFines(@RequestHeader("userId") String userId) {
        return finesService.loadFines(UserData.builder()
                .userId(userId)
                .build());
    }
}

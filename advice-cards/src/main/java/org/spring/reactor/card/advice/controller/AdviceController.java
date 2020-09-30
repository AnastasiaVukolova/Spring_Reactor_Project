package org.spring.reactor.card.advice.controller;

import lombok.RequiredArgsConstructor;
import org.spring.reactor.card.advice.entity.AdviceCard;
import org.spring.reactor.card.advice.service.AdviceService;
import org.spring.reactor.card.entity.GeoPosition;
import org.spring.reactor.card.entity.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class AdviceController {
    private final AdviceService adviceService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<AdviceCard> loadAdvices(@RequestHeader("userId") String userId,
                                        @RequestHeader("longitude") BigDecimal longitude,
                                        @RequestHeader("latitude") BigDecimal latitude,
                                        @RequestParam("currentDate") Long currentDate) {
        return adviceService.defineAdvices(UserData.builder()
                .currentDate(currentDate)
                .userId(userId)
                .geoPosition(GeoPosition.builder()
                        .latitude(latitude)
                        .longitude(longitude)
                        .build())
                .build());
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/basic", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AdviceCard> loadAdvicesBasic(@RequestHeader("userId") String userId,
                                        @RequestHeader("longitude") BigDecimal longitude,
                                        @RequestHeader("latitude") BigDecimal latitude,
                                        @RequestParam("currentDate") Long currentDate) {
        return adviceService.defineAdvicesBasic(UserData.builder()
                .currentDate(currentDate)
                .userId(userId)
                .geoPosition(GeoPosition.builder()
                        .latitude(latitude)
                        .longitude(longitude)
                        .build())
                .build());
    }
}

package org.spring.reactor.remote.faker.controller;

import lombok.RequiredArgsConstructor;
import org.spring.reactor.remote.faker.entity.FineDTO;
import org.spring.reactor.remote.faker.service.FakeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FakeController {
    private final FakeService fakeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/fines", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FineDTO> loadFines(@RequestHeader("userId") String userId) {
        return fakeService.loadFakes(userId);
    }
}

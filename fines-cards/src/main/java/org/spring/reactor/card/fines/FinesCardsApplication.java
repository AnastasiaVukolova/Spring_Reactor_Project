package org.spring.reactor.card.fines;

import org.spring.reactor.card.fines.configuration.FinesProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FinesProperties.class})
public class FinesCardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinesCardsApplication.class, args);
    }
}

package org.spring.reactor.card.regular;

import org.spring.reactor.card.regular.configuration.RegularProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableConfigurationProperties({RegularProperties.class})
public class RegularCardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegularCardsApplication.class, args);
    }
}

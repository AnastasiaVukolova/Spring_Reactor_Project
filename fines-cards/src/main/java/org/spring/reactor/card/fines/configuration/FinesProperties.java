package org.spring.reactor.card.fines.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "fines")
public class FinesProperties {
    private String executeUrl;
}

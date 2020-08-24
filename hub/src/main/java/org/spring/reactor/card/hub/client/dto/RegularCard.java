package org.spring.reactor.card.hub.client.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.spring.reactor.card.entity.Card;
import org.spring.reactor.card.entity.CardType;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class RegularCard extends Card {
    private String targetAccount;
    private Long dueDate;

    @Builder
    public RegularCard(String id, String userId, CardType type, BigDecimal amount,
                       String executionUrl, String targetAccount, Long dueDate) {
        super(id, userId, type, amount, executionUrl);
        this.targetAccount = targetAccount;
        this.dueDate = dueDate;
    }
}

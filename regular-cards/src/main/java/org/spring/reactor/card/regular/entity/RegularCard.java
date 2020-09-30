package org.spring.reactor.card.regular.entity;

import lombok.Builder;
import lombok.Data;
import org.spring.reactor.card.entity.Card;
import org.spring.reactor.card.entity.CardType;

import java.math.BigDecimal;

@Data
public class RegularCard extends Card {
    private String targetAccount;
    private String dueDate;

    @Builder
    public RegularCard(String id, String userId, CardType type, BigDecimal amount,
                       String executionUrl, String targetAccount, String dueDate) {
        super(id, userId, type, amount, executionUrl);
        this.targetAccount = targetAccount;
        this.dueDate = dueDate;
    }

    public RegularCard() {
    }
}

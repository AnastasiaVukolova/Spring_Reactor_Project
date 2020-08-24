package org.spring.reactor.card.fines.entity;

import lombok.Builder;
import lombok.Data;
import org.spring.reactor.card.entity.Card;
import org.spring.reactor.card.entity.CardType;

import java.math.BigDecimal;

@Data
public class FineCard extends Card {
    private FineType fineType;
    private Long dueDate;

    @Builder
    public FineCard(String id, String userId, CardType type, BigDecimal amount, String executionUrl, FineType fineType, Long dueDate) {
        super(id, userId, type, amount, executionUrl);
        this.fineType = fineType;
        this.dueDate = dueDate;
    }
}

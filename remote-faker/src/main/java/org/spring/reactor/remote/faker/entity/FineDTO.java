package org.spring.reactor.remote.faker.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.spring.reactor.card.entity.Card;
import org.spring.reactor.card.entity.CardType;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class FineDTO {
    private String id;
    private BigDecimal amount;
    private FineType fineType;
    private String dueDate;

    @Builder
    public FineDTO(String id, BigDecimal amount, FineType fineType, String dueDate) {
        this.id = id;
        this.amount = amount;
        this.fineType = fineType;
        this.dueDate = dueDate;
    }
}

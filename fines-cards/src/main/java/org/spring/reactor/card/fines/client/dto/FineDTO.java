package org.spring.reactor.card.fines.client.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.spring.reactor.card.fines.entity.FineType;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class FineDTO {
    private String id;
    private BigDecimal amount;
    private FineType fineType;
    private Date dueDate;

    @Builder
    public FineDTO(String id, BigDecimal amount, FineType fineType, Date dueDate) {
        this.id = id;
        this.amount = amount;
        this.fineType = fineType;
        this.dueDate = dueDate;
    }
}

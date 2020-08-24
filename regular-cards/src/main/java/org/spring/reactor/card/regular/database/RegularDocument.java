package org.spring.reactor.card.regular.database;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class RegularDocument {
    private String id;
    private String targetAccount;
    private Date dueDate;
    private String userId;
    private BigDecimal amount;
}

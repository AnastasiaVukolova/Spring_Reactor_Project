package org.spring.reactor.card.advice.entity;

public enum AdviceType {
    GIFT,
    TAXI,
    CURRENCY;

    public static AdviceType fromInt(int i) {
        return AdviceType.values()[i];
    }
}

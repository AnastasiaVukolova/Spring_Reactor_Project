package org.spring.reactor.card.fines.entity;

public enum FineType {
    CAR,
    ADMINISTRATIVE,
    TAX;

    public static FineType fromInt(int i) {
        return FineType.values()[i];
    }
}

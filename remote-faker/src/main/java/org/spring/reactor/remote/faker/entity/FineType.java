package org.spring.reactor.remote.faker.entity;

public enum FineType {
    CAR,
    ADMINISTRATIVE,
    TAX;

    public static FineType fromInt(int i) {
        return FineType.values()[i];
    }
}

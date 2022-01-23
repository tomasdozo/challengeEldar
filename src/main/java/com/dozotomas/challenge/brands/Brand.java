package com.dozotomas.challenge.brands;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode
@Setter(AccessLevel.PROTECTED)
public abstract class Brand {
    private String name;

    public abstract double rate();

    @Override
    public String toString() {
        return name;
    }
}

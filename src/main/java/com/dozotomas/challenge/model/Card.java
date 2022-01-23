package com.dozotomas.challenge.model;

import com.dozotomas.challenge.brands.Brand;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Card {
    private long number;
    private String cardholder;
    private LocalDate expiration;
    private Brand brand;

    @Override
    public String toString() {
        return "Card{" +
                "number=" + Long.toUnsignedString(number) +
                ", cardholder='" + cardholder + '\'' +
                ", expiration=" + expiration +
                ", brand=" + brand +
                '}';
    }
}

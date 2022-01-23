package com.dozotomas.challenge.model;

import com.dozotomas.challenge.exceptions.InvalidCardException;
import com.dozotomas.challenge.exceptions.InvalidOperationException;
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
    private static final int maxValue = 1000;

    public boolean isValidOperation (int value) {
        return value <= maxValue;
    }

    public boolean isValidCard () {
        return LocalDate.now().isBefore(expiration);
    }

    public String rate(int value) throws InvalidCardException, InvalidOperationException {
        if (LocalDate.now().isAfter(expiration)) throw new InvalidCardException("Card invalid, it is expired.");
        if (value>maxValue) throw new InvalidOperationException("Operation invalid, the value is bigger than " + maxValue + ".");
        return ("The card brand is: " + brand.getName()+". The value of the operation is: " + value+ ". The rate for the operation is: " + brand.rate() + "%.");
    }

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

package com.dozotomas.challenge.utils;

import com.dozotomas.challenge.brands.Brand;
import com.dozotomas.challenge.exceptions.BrandNotFoundException;
import com.dozotomas.challenge.exceptions.InvalidOperationException;
import com.dozotomas.challenge.model.Card;

import java.time.LocalDate;
import java.util.Locale;

public abstract class Utils {
    public static final double maxValue = 1000;

    public static boolean isValidOperation(double value) {
        return value <= maxValue;
    }

    public static boolean isValidCard(Card card) {
        return LocalDate.now().isBefore(card.getExpiration());
    }

    public static double fee(String brandString, Double value) throws InvalidOperationException, BrandNotFoundException {
        if (value > maxValue)
            throw new InvalidOperationException("The operation is invalid. The value is bigger than: " + maxValue);
        BrandEnums brand;
        try {
            brand = BrandEnums.valueOf(brandString.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException e) {
            throw new BrandNotFoundException("The brand " + brandString + " couldn't be found.");
        }
        return value * (brand.getInstance().rate() + 1);
    }
}

package com.dozotomas.challenge.utils;

import com.dozotomas.challenge.brands.Amex;
import com.dozotomas.challenge.brands.Brand;
import com.dozotomas.challenge.brands.Nara;
import com.dozotomas.challenge.brands.Visa;
import lombok.Getter;

@Getter
public enum BrandEnums {
    VISA(Visa.getInstance()),AMEX(Amex.getInstance()),NARA(Nara.getInstance());
    private final Brand instance;

    BrandEnums(Brand brand) {
        this.instance = brand;
    }


}

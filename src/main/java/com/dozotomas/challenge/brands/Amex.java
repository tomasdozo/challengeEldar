package com.dozotomas.challenge.brands;

import java.time.LocalDate;


public class Amex extends Brand{
    private static Amex instance = null;

    public Amex() {
        this.setName("AMEX");
    }

    @Override
    public double rate() {
        LocalDate date = LocalDate.now();
        return (date.getMonthValue() * 0.1)/100;
    }

    public static Amex getInstance(){
        if(instance==null){
            instance = new Amex();
        }
        return instance;
    }
}

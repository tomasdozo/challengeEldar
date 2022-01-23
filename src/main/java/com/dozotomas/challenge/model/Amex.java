package com.dozotomas.challenge.model;

import java.time.LocalDate;
import java.util.Calendar;


public class Amex extends Brand{
    private static Amex instance = null;

    public Amex() {
        this.setName("AMEX");
    }

    @Override
    public float rate() {
        LocalDate date = LocalDate.now();
        return (float) date.getMonthValue() * 0.1f;
    }

    public static Amex getInstance(){
        if(instance==null){
            instance = new Amex();
        }
        return instance;
    }
}

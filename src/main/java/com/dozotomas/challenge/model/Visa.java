package com.dozotomas.challenge.model;

import java.time.LocalDate;
import java.util.Calendar;


public class Visa extends Brand{
    private static Visa instance = null;

    public Visa() {
        this.setName("VISA");
    }

    @Override
    public float rate() {
        LocalDate date = LocalDate.now();
        return (float) (date.getYear() % 100) / date.getMonthValue();
    }

    public static Visa getInstance(){
        if(instance==null){
            instance = new Visa();
        }
        return instance;
    }
}

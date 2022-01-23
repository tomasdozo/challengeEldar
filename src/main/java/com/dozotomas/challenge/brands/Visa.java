package com.dozotomas.challenge.brands;

import java.time.LocalDate;

public class Visa extends Brand{
    private static Visa instance = null;

    public Visa() {
        this.setName("VISA");
    }

    @Override
    public double rate() {
        LocalDate date = LocalDate.now();
        return  ((double) (date.getYear() % 100) / date.getMonthValue())/100;
    }

    public static Visa getInstance(){
        if(instance==null){
            instance = new Visa();
        }
        return instance;
    }
}

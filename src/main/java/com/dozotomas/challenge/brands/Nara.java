package com.dozotomas.challenge.brands;

import java.time.LocalDate;


public class Nara extends Brand{
    private static Nara instance = null;

    public Nara() {
        this.setName("NARA");
    }

    @Override
    public double rate() {
        LocalDate date= LocalDate.now();
        return  (date.getDayOfMonth() * 0.5)/100;
    }

    public static Nara getInstance(){
        if(instance==null){
            instance = new Nara();
        }
        return instance;
    }
}

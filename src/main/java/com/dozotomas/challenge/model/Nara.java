package com.dozotomas.challenge.model;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Calendar;


public class Nara extends Brand{
    private static Nara instance = null;

    public Nara() {
        this.setName("NARA");
    }

    @Override
    public float rate() {
        LocalDate date= LocalDate.now();
        return (float) date.getDayOfMonth() * 0.5f;
    }

    public static Nara getInstance(){
        if(instance==null){
            instance = new Nara();
        }
        return instance;
    }
}

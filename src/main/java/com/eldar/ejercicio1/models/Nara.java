package com.eldar.ejercicio1.models;

import java.time.LocalDate;

public class Nara extends Brand {

    public Nara(String name) {
        super(name);
    }

    @Override
    public double calculateRate(LocalDate date) {
        return date.getDayOfMonth() * 0.5;
    }

}

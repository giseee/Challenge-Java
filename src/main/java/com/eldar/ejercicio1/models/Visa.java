package com.eldar.ejercicio1.models;

import java.time.LocalDate;

public class Visa extends Brand {
    public Visa(String name) {
        super(name);
    }

    @Override
    public double calculateRate(LocalDate date) {
        int digitAnio = date.getYear() % 100;
        return (double)  digitAnio/date.getMonthValue();
    }
}

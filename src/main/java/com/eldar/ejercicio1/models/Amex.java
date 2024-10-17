package com.eldar.ejercicio1.models;

import java.time.LocalDate;

public class Amex extends Brand {
    public Amex(String name) {
        super(name);
    }

    @Override
    public double calculateRate(LocalDate date) {
        return date.getMonthValue() * 0.1;
    }

}

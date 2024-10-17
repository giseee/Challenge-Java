package com.eldar.ejercicio1.models;

import com.eldar.ejercicio1.exceptions.InvalidOperationException;

import java.time.LocalDate;

public abstract class Brand {

    private String name;

    public Brand(String name) {
        this.name = name;
    }

    public double calculateRateWithValidation(LocalDate date) throws InvalidOperationException {
        if (date == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }
        double rate = calculateRate(date);
        if (rate < 0.3||rate > 5) {
            throw new InvalidOperationException("La tasa no es valida: " + rate);
        }
        return rate;
    }
    public abstract double calculateRate(LocalDate date);

    public String getName() {
        return name;
    }

}

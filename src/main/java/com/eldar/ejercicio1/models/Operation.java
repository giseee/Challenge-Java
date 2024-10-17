package com.eldar.ejercicio1.models;

import com.eldar.ejercicio1.exceptions.InvalidOperationException;

public class Operation {
    private long id;
    private double amount;
    private Card card;

    public Operation() {
    }
    public Operation( double amount, Card card) {
        if(!card.isValid() || !isValid(amount)) {
            throw new InvalidOperationException("Tarjeta vencida o el monto no es valido, no puede realizar la operación");
        }
        this.amount = amount;
        this.card = card;
    }
    public boolean isValid(double amount) {
        return amount < 1000;
    }
    public String getInformacion() {
        return "nombre: " + this.card.getBrand().getName() + " importe: " + this.amount;
    }
}

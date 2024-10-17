package com.eldar.ejercicio1.models;

import com.eldar.ejercicio1.exceptions.InvalidOperationException;

import java.time.DateTimeException;
import java.time.LocalDate;


public class SystemCard {
    public static void main(String[] args) {
        Brand visa = new Visa("Visa");
        try {
              Card cardVisa = new Card("987654321", "Carlos B Perez", LocalDate.of(2026, 5, 15), visa);
            Operation operation = new Operation(500, cardVisa);
            System.out.println("Detalle de la tarjeta: " + cardVisa);
            System.out.println("La operación es valida: " + operation.isValid(100));
            System.out.println("La tarjeta es valida: " + cardVisa.isValid());
            System.out.println(cardVisa.cardIsEqualTo(cardVisa));
            System.out.println("la tasa de la tarjeta número: "+cardVisa.getNumber() + " es " + operation.calculateTotalRate());
        }  catch (InvalidOperationException | DateTimeException e) {
            System.out.println(e.getMessage());
        }
    }
}


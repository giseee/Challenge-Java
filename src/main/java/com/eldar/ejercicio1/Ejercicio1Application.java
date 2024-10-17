package com.eldar.ejercicio1;

import com.eldar.ejercicio1.exceptions.InvalidOperationException;
import com.eldar.ejercicio1.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.DateTimeException;
import java.time.LocalDate;

@SpringBootApplication
public class Ejercicio1Application {

    public static void main(String[] args) {
        SpringApplication.run(Ejercicio1Application.class, args);

    Brand nara = new Nara("Nara");
    Brand visa = new Visa("Visa");
    try {
        Card cardNara = new Card("123456789", "Juana A Gomez", LocalDate.of(2025, 10, 1), nara);
        Card cardVisa = new Card("987654321", "Carlos B Perez", LocalDate.of(2024, 5, 15), visa);
        Operation operation = new Operation(500, cardNara);
        System.out.println("Detalle de la tarjeta: " + cardNara);
        System.out.println("La operación es valida: " + operation.isValid(100));
        System.out.println("La tarjeta es valida: " + cardNara.isValid());
        System.out.println(cardNara.cardIsEqualTo(cardVisa));
        System.out.println("la tasa de la tarjeta número: " + cardNara.getNumber() + " es " + cardNara.getBrand().calculateRate(LocalDate.of(2023, 10, 3)));
    } catch (InvalidOperationException | DateTimeException e) {
        System.out.println(e.getMessage());
    }
}
}

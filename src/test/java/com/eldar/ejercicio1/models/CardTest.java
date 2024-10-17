package com.eldar.ejercicio1.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {

    private Brand visa = new Visa("VISA");
    private Brand nara = new Nara("NARA");
    private Brand amex = new Amex("AMEX");
    private Card card;
    private Card card1;
    private Card card2;
    @BeforeEach
    void contextLoads() {
        card = new Card("1111-2222-3333-4447", "Susana Perez", LocalDate.of(2026, 12, 1), visa);
        card1 = new Card("1111-2002-4444-4447", "Lola R Rodriguez", LocalDate.of(2027, 6, 20), nara);
        card2 = new Card("25624-2002-4444-4447", "Gise Rodriguez", LocalDate.of(2026, 5, 10),amex);
    }

    @Test
    void testCardValidations() {
        assert(card.isValid());
    }
    @Test
    void testCardInvalidations() {
        card = new Card("1111-2222-3333-4447", "Susana Perez", LocalDate.of(2024, 1, 1), visa);
        assert(!card.isValid());
    }
    @Test
    void testInformationCard() {
        assertEquals(card1.toString(), "Tarjeta:  número= 1111-2002-4444-4447,nombre y apellido= Lola R Rodriguez', fecha de vencimiento= 2027-06-20, marca=NARA");
    }
    @Test
    void testCardIsEqual() {
        assertEquals(card.cardIsEqualTo(card2), "Las tarjetas son diferentes");
    }
}

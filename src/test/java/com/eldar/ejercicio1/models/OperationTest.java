package com.eldar.ejercicio1.models;

import com.eldar.ejercicio1.exceptions.InvalidOperationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {
    private static Card card;
    private static Card card1;
    private static Card card2;
    @BeforeEach
    void contextLoads() {
        Brand nara=new Nara("NARA");
        Brand visa=new Visa("VISA");
        Brand amex=new Amex("AMEX");
        card = new Card("1111-2222-3333-4447", "Susana Perez", LocalDate.of(2026,12,1), visa);
        card1 = new Card("1111-2002-4444-4447", "Lola R Rodriguez", LocalDate.of(2027,6,20), nara);
        card2 = new Card("25624-2002-4444-4447", "Gise Rodriguez", LocalDate.of(2026,5,10), amex);
    }
    @Test
    void testOperationValid() {
        Operation operation = new Operation( 100, card);
        assertTrue(operation.isValid(450));

    }
    @Test
    void getInformacion() throws InvalidOperationException {
        Operation op =new Operation(500,card);
        assertEquals(op.getInformacion(),"nombre: VISA importe: 500.0");
    }
    @Test
    void testCalculateRateVisa() throws InvalidOperationException {
        assertEquals(card.getBrand().calculateRateWithValidation(LocalDate.of(2024, 12, 1)),2);
    }
    @Test
    void testCalculateRateNara() throws InvalidOperationException {
        assertEquals(card1.getBrand().calculateRateWithValidation(LocalDate.of(2024, 12, 1)),0.5);
    }
    @Test
    void testCalculateRateAmex() throws InvalidOperationException {
        assertEquals(card2.getBrand().calculateRateWithValidation(LocalDate.of(2024, 11, 20)),1.1);
    }
}
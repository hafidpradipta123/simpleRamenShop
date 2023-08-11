package org.RamenShop;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MoneyMachineTest {

    @Test
    void report() {
        MoneyMachine moneyMachine = new MoneyMachine();
        moneyMachine.makePayment(800, 1000);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        moneyMachine.report();

        System.setOut(System.out);

        String expectedOutput = "Money ¥200\n";
        assertEquals(expectedOutput, outputStream.toString());

    }

    @Test
    void processMoney() {
        MoneyMachine moneyMachine = new MoneyMachine();
        String input = "2\n3\n4\n";
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        int totalMoneyReceived = moneyMachine.processMoney();
        System.setIn(originalSystemIn);
        System.setOut(System.out);

        double expectedTotal = (500 * 2) + (200 * 3) + (100 * 4) ;
        assertEquals(expectedTotal, totalMoneyReceived, 0.001);

        String expectedOutput =
                "How many 500 Yen?:\nHow many 200 Yen?:\nHow many 100 Yen?:\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void makePayment() {
        MoneyMachine moneyMachine = new MoneyMachine();
        boolean paymentResult = moneyMachine.makePayment(800,1000);
        assertTrue(paymentResult);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        moneyMachine.makePayment(800,1000);
        System.setOut(System.out);

        String expectedOutput = "Here is your change ¥200\n";
        assertEquals(expectedOutput, outputStream.toString());

    }

    @Test
    void failedMakePayment() {
        MoneyMachine moneyMachine = new MoneyMachine();
        boolean paymentResult = moneyMachine.makePayment(800,200);
        assertFalse(paymentResult);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        moneyMachine.makePayment(800,200);
        System.setOut(System.out);

        String expectedOutput = "You don't have enough money. The money got refunded\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
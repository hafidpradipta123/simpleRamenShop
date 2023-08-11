package org.RamenShop;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RamenMakerTest {

    @Test
    void report() {
        RamenMaker ramenMaker = new RamenMaker();


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ramenMaker.report();

        System.setOut(System.out);

        String expectedOutput = "Broth:  6 portion\n" +
                "Mushroom:  2 portion\n" +
                "Egg:  4 portion\n" +
                "Noodle:  1 portion\n" +
                "Seaweed:  1 portion\n" +
                "Chili:  4 portion\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void isResourcesSufficient() {
        RamenMaker coffeeMaker = new RamenMaker();
        RamenItem item = new RamenItem("test", 800, 2, 1, 1,1,1,1);

        assertTrue(coffeeMaker.isResourcesSufficient(item.getIngredients()));
    }

    @Test
    void isResourcesNotSufficient() {
        RamenMaker ramenMaker = new RamenMaker();
        RamenItem item = new RamenItem("test", 800, 20, 1, 1,1,1,1);

        assertFalse(ramenMaker.isResourcesSufficient(item.getIngredients()));
    }

    @Test
    void makeCoffee() {
        RamenMaker ramenMaker = new RamenMaker();
        RamenItem item = new RamenItem("Spicy Pork ", 800, 20, 1, 1,1,1,1);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ramenMaker.makeRamen(item);

        System.setOut(System.out);

        String expectedOutput = "Here is your Spicy Pork  ramen. Enjoy!\n";
        assertEquals(expectedOutput, outputStream.toString());


    }
}
package org.RamenShop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RamenMenuTest {

    @Test
    void getItems() {
        RamenMenu ramenMenu = new RamenMenu();
        String expectedOutput = "Pork/Spicy Pork/Spicy Spc Pork/";
        assertEquals(expectedOutput, ramenMenu.getItems());
    }
}
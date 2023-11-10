package com.example.salestaxes.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodProductTest {

    final float THRESHOLD = 0.0000000001f;

    @Test
    void localFoodProductCalcTaxeShouldReturnZero() {
        Product chocolateBar = new FoodProduct("chocolate bar", 0.85f, false);
        float result = chocolateBar.calcTaxes();
        assertEquals(0, result);
    }

    @Test
    void importedFoodProductCalcTaxeShouldReturnExpectedValue() {
        Product importedChocolate = new FoodProduct("box of imported chocolates", 11.25f, true);
        float result = importedChocolate.calcTaxes();
        float expectedValue = 0.55f;
        assertTrue(Math.abs(result - expectedValue) < THRESHOLD);

    }
}
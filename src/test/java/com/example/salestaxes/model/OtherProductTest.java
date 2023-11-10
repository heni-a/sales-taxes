package com.example.salestaxes.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OtherProductTest {

    final float THRESHOLD = 0.0000000001f;

    @Test
    void localOtherProductCalcTaxeShouldReturnZero() {
        Product perfume = new OtherProduct("bottle of perfume", 20.00f, false);
        float result = perfume.calcTaxes();
        assertEquals(2, result);
    }

    @Test
    void importedOtherProductCalcTaxeShouldReturnExpectedValue() {
        Product importedPerfume = new OtherProduct("imported bottle of perfume", 47.50f, true);
        float result = importedPerfume.calcTaxes();
        float expectedValue = 7.15f;
        assertTrue(Math.abs(result - expectedValue) < THRESHOLD);
    }
}
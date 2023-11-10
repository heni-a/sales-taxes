package com.example.salestaxes.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicalProductTest {

    final float THRESHOLD = 0.0000000001f;

    @Test
    void localMedicalProductCalcTaxeShouldReturnZero() {
        Product headachePills = new MedicalProduct("packet of headache pills", 9.75f, false);
        float result = headachePills.calcTaxes();
        assertEquals(0, result);
    }

    @Test
    void importedMedicalProductCalcTaxeShouldReturnExpectedValue() {
        Product importedHeadachePills = new MedicalProduct("imported packet of headache pills", 9.75f, true);
        float result = importedHeadachePills.calcTaxes();
        float expectedValue = 0.5f;
        assertTrue(Math.abs(result - expectedValue) < THRESHOLD);
    }
}
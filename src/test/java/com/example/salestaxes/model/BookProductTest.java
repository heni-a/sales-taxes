package com.example.salestaxes.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookProductTest {

    final float THRESHOLD = 0.0000000001f;

    @Test
    void localBookProductCalcTaxeShouldReturnZero() {
        Product book = new BookProduct("book", 12.49f, false);
        float result = book.calcTaxes();
        assertEquals(0, result);
    }

    @Test
    void importedBookProductCalcTaxeShouldReturnExpectedValue() {
        Product importedBook = new BookProduct("book", 12.49f, true);
        float result = importedBook.calcTaxes();
        float expectedValue = 0.6f;
        assertTrue(Math.abs(result - expectedValue) < THRESHOLD);
    }
}
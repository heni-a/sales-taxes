package com.example.salestaxes.util;

import com.example.salestaxes.model.BookProduct;
import com.example.salestaxes.model.FoodProduct;
import com.example.salestaxes.model.OtherProduct;
import com.example.salestaxes.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    final float THRESHOLD = 0.0000000001f;

    ICalculator calculator = new Calculator();
    List<Product> productList;
    float sumTaxes;

    @BeforeEach
    void setUp(){
        Product book = new BookProduct("book", 12.49f, false);
        Product musicCd = new OtherProduct("music CD", 14.99f, false);
        Product chocolateBar = new FoodProduct("chocolate bar", 0.85f, false);
        productList = List.of(book, musicCd, chocolateBar);
        sumTaxes = calculator.sumTaxes(productList);
    }

    @Test
    void sumTaxesShouldReturnNonZeroResult() {
        assertNotEquals(0, sumTaxes);
    }

    @Test
    void sumTaxesShouldReturnExpectedValue() {
        float expectedValue = 1.5f;
        assertTrue(Math.abs(sumTaxes - expectedValue) < THRESHOLD);
    }

    @Test
    void sumPricesShouldReturnNonZeroResult() {
        float sumPrices = calculator.sumPrices(productList);
        assertNotEquals(0, sumPrices);
    }

    @Test
    void sumPricesShouldReturnExpectedValue() {
        float sumPrices = calculator.sumPrices(productList);
        float expectedValue = 29.83f;
        assertTrue(Math.abs(sumPrices - expectedValue) < THRESHOLD);
    }
}
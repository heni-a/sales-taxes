package com.example.salestaxes.util;

import com.example.salestaxes.model.Product;

import java.util.List;

public interface ICalculator {
    float sumTaxes(List<Product> productList);

    float sumPrices(List<Product> productList);
}

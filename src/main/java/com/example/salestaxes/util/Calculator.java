package com.example.salestaxes.util;


import com.example.salestaxes.model.Product;

import java.util.List;

public class Calculator implements ICalculator {

    @Override
    public float sumTaxes(List<Product> productList){
        float sumTaxes = 0;
        for (Product product : productList){
            sumTaxes += product.calcTaxes();
        }
        return sumTaxes;
    }

    @Override
    public float sumPrices(List<Product> productList){
        float sumPrices = 0;
        for (Product product : productList){
            sumPrices += product.getPrice();
        }
        return sumPrices;
    }
}

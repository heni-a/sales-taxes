package com.example.salestaxes.util;

import com.example.salestaxes.model.Product;

import java.text.DecimalFormat;
import java.util.List;

public class ReceiptPrinter {

    private final ICalculator calculator;

    public ReceiptPrinter(ICalculator calculator){
        this.calculator = calculator;
    }
    public void printReceipt(List<Product> productList){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        float taxes = calculator.sumTaxes(productList);
        float pricess = calculator.sumPrices(productList);

        System.out.println("Receipt :");
        for (Product product : productList){
            System.out.println("1 " + product.getName() + " : " + decimalFormat.format(product.getPrice()));
        }
        System.out.println("Sales Taxes : " + decimalFormat.format(taxes));
        System.out.println("Total : " + decimalFormat.format(pricess));
    }
}

package com.example.salestaxes.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
abstract public class Product {
    String name;
    float price;
    boolean isImported;

    public abstract float calcTaxes();
}

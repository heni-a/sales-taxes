package com.example.salestaxes.model;

public class MedicalProduct extends Product{

    public MedicalProduct(String name, float price, boolean isImported) {
        super(name, price, isImported);
    }

    @Override
    public float calcTaxes() {
        float productImportTax = 0;
        float importTaxPercentage = 5;

        float priceWithNoTaxes = this.getPrice();

        // calculate the import taxe
        if(this.isImported()){
            float importTax = (priceWithNoTaxes*importTaxPercentage)/100;
            productImportTax = Math.round(importTax/0.05f)*0.05f;
            this.setPrice(priceWithNoTaxes+productImportTax);
        }

        return productImportTax;
    }
}

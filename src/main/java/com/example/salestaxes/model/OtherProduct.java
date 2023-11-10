package com.example.salestaxes.model;

public class OtherProduct extends Product{

    public OtherProduct(String name, float price, boolean isImported) {
        super(name, price, isImported);
    }

    @Override
    public float calcTaxes() {
        float productImportTax = 0;
        float localTaxPercentage = 10;
        float importTaxPercentage = 5;

        // calculate the local tax
        float priceWithNoTaxes = this.getPrice();
        float localTax = (priceWithNoTaxes*localTaxPercentage)/100;
        float productLocalTax = Math.round(localTax/0.05f) * 0.05f;
        this.setPrice(priceWithNoTaxes+productLocalTax);

        // calculate the import tax
        if(this.isImported()){
            float importTax = (priceWithNoTaxes*importTaxPercentage)/100;
            productImportTax = Math.round(importTax/0.05f)*0.05f;
            this.setPrice(this.getPrice()+productImportTax);
        }

        return productLocalTax+productImportTax;
    }
}

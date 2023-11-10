package com.example.salestaxes;


import com.example.salestaxes.model.*;
import com.example.salestaxes.util.Calculator;
import com.example.salestaxes.util.ICalculator;
import com.example.salestaxes.util.ReceiptPrinter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SalesTaxesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesTaxesApplication.class, args);
		/*** Example 1 ***/
		Product book = new BookProduct("book", 12.49f, false);
		Product musicCd = new OtherProduct("music CD", 14.99f, false);
		Product chocolateBar = new FoodProduct("chocolate bar", 0.85f, false);
		List<Product> productList = List.of(book, musicCd, chocolateBar);


		/*** Example 2 ***/
        /*Product importedChocolate = new FoodProduct("imported box of chocolates", 10.00f, true);
        Product importedPerfume = new OtherProduct("imported bottle of perfume", 47.50f, true);
        List<Product> productList = List.of(importedChocolate, importedPerfume);*/


		/*** Example 3 ***/
        /*Product importedPerfume = new OtherProduct("imported bottle of perfume", 27.99f, true);
        Product perfume = new OtherProduct("bottle of perfume", 18.99f, false);
        Product headachePills = new MedicalProduct("packet of headache pills", 9.75f, false);
        Product importedChocolate = new FoodProduct("box of imported chocolates", 11.25f, true);
        List<Product> productList = List.of(
                importedPerfume,
                perfume,
                headachePills,
                importedChocolate
        );*/





		ICalculator calculator = new Calculator();
		// Print the result
		ReceiptPrinter printer = new ReceiptPrinter(calculator);
		printer.printReceipt(productList);

	}

}

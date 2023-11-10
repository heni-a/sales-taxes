package com.example.salestaxes.util;

import com.example.salestaxes.model.BookProduct;
import com.example.salestaxes.model.FoodProduct;
import com.example.salestaxes.model.OtherProduct;
import com.example.salestaxes.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

class ReceiptPrinterTest {
    List<Product> productList;

    @BeforeEach
    void setUp(){
        Product book = new BookProduct("book", 12.49f, false);
        Product musicCd = new OtherProduct("music CD", 14.99f, false);
        Product chocolateBar = new FoodProduct("chocolate bar", 0.85f, false);
        productList = List.of(book, musicCd, chocolateBar);
    }

    @Test
    void printReceiptShouldBeCalledOneTime() {
        ReceiptPrinter printer = mock(ReceiptPrinter.class);
        doNothing().when(printer).printReceipt(Mockito.anyList());
        printer.printReceipt(productList);

        verify(printer, times(1)).printReceipt(productList);
    }
}
package org.example;

import org.example.CurrencyData.JsonFileReader;

import java.io.IOException;

public class CurrencyConverter {

    private static JsonFileReader currency;

    public static void main(String[] args) {
        try {
            currency = new JsonFileReader();
        } catch (IOException e) {
            System.err.println("Problem with data.json: " + e.getMessage());
            return;
        }

        // Example usage:
        System.out.println(currency.getData("USD")); // should print 1
        // use something in the data.json file
    }
}

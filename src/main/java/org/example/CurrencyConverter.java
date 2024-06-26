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

        System.out.println(currency.getData("USD"));
        // ask for currency to convert from
        // if this is not USD convert to usd
        // then convert to other currency!!!

    }
}

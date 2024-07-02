package org.example;

import org.example.CurrencyData.JsonFileReader;

import java.io.IOException;

import java.util.Scanner;

public class CurrencyConverter {

    private static JsonFileReader currency;

    public static void main(String[] args) {
        try {
            currency = new JsonFileReader();
        } catch (IOException e) {
            System.err.println("Problem with data.json: " + e.getMessage());
            return;
        }
        //scanner
        Scanner in = new Scanner(System.in);
        System.out.println("What currency would you like to start from?");
        String name1 = in.nextLine();
        System.out.println("What currency would you like to convert to?");
        String name2 = in.nextLine();
        CurrencyConverter converter = new CurrencyConverter();
        System.out.println("How much do you want to convert?");
        double value1 = in.nextDouble();
        double convertedValue = converter.currTocurr(name1 , value1, name2);
        System.out.println("converted value: " + convertedValue);

        // ask for currency to convert from
        // if this is not USD convert to usd
        // then convert to other currency!!!


        //System.out.println("What is your currency you would like to start with?");
    }
    public double usdConversion (String whatever, double value)
    {
        return currency.getData(whatever)*value;
    }

    public double conversionToUSD (String curr, double value)
    {
        return value/currency.getData(curr);
    }

    public double currTocurr (String curr1, double value, String curr2)
    {
        return usdConversion(curr2, conversionToUSD(curr1,value));
    }
}
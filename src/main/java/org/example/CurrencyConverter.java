package org.example;

import org.example.CurrencyData.JsonFileReader;

import java.io.IOException;

public class CurrencyConverter {

    public static JsonFileReader currency;

    public static void main(String[] args) {
        try {
            currency = new JsonFileReader();
        } catch (IOException e) {
            System.err.println("Problem with data.json: " + e.getMessage());
            return;
        }
        CurrencyConverter converter = new CurrencyConverter();
        double convertedValue = converter.currTocurr("SBD", 10,"INR");
        System.out.println("Converted value: " + convertedValue);
        // ask for currency to convert from
        // if this is not USD convert to usd
        // then convert to other currency!!!
    }

    public double usdConversion(String curr, double value){
            return currency.getData(curr)*value;
            //return 1;
    }

    public double conversionToUSD(String curr, double value){
        return value/currency.getData(curr);//currency.getData(curr)/value

        //return 1;
    }

     public double currTocurr(String curr1, double value, String curr2){
       return usdConversion(curr2,conversionToUSD(curr1,value));
     }

}

package org.example;

import org.example.CurrencyData.JsonFileReader;

import java.io.IOException;
import java.text.DecimalFormat;


public class CurrencyConverter {

    private static final DecimalFormat defactor = new DecimalFormat("0.000");

    private static JsonFileReader currency;
    public CurrencyConverter(){
        try {
            currency = new JsonFileReader();
        } catch (IOException e) {
            System.err.println("Problem with data.json: \n" + e.getMessage());
        }
    }
    public double usdConversion (String currency, double value)
    {
        return Double.parseDouble(defactor.format((CurrencyConverter.currency.getData(currency)*value)));
    }

    public double conversionToUSD (String currency, double value)
    {

        return Double.parseDouble(defactor.format((value/CurrencyConverter.currency.getData(currency))));
        //(value/CurrencyConverter.currency.getData(currency))
    }

    public double currToCurr (String curr1, double amount, String curr2)
    {
        return Double.parseDouble(defactor.format((usdConversion(curr2, conversionToUSD(curr1,amount)))));
        //decfor.format(num
    }
}
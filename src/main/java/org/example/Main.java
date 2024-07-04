package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        CurrencyConverter converter = new CurrencyConverter();
        Scanner in = new Scanner(System.in);
        System.out.println("What currency would you like to start from?");
        String curr1 = in.nextLine();
        System.out.println("What currency would you like to conINRvert to?");
        String curr2 = in.nextLine();
        System.out.println("How much do you want to convert?");
        double amount = in.nextDouble();
        double convertedValue = converter.currToCurr(curr1 , amount, curr2);
        System.out.println("converted value: " + convertedValue);
    }

}

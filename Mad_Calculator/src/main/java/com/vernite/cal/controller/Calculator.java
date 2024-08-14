package com.vernite.cal.controller;

public class Calculator {

    // calculate credit card interest amount

    public double calculateInterest(String creditCardType, int balance ) {
        double rate = 0;
        if (creditCardType.equals("DISCOVER")) {
            rate = .01;
        } if (creditCardType.equals("MASTERCARD")) {
            rate = .05;
        } if (creditCardType.equals("VISA")) {
            rate = .10;
        }

        return rate * balance;
    }

}

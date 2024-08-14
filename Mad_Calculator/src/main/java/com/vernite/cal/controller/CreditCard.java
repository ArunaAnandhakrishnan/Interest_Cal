package com.vernite.cal.controller;

public class CreditCard {

    private final String type;
    private int balance;

    // credit card constructor only accepts Discover, MasterCard or Visa.

    //TODO shorten first if statement

    public CreditCard(String type, int balance) throws IllegalArgumentException {
        if ( ("DISCOVER".equals(type.toUpperCase())) || ("MASTERCARD".equals(type.toUpperCase())) || ("VISA".equals(type.toUpperCase())) ) {
            this.type = type.toUpperCase();
        } else {
            throw new IllegalArgumentException("Sorry, wallet only accepts Discover, MasterCard, Visa.");
        }
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    // uses the calculator object to find the amount of interest a customer will pay

    public double getInterestPayment() {
        Calculator calculator = new Calculator();
        return calculator.calculateInterest(type, balance);
    }
}






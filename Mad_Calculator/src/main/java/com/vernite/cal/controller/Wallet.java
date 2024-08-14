package com.vernite.cal.controller;


import java.util.ArrayList;

public class Wallet {

    final ArrayList<CreditCard> creditCards = new ArrayList<>();

    public ArrayList<CreditCard> getCreditCards() {
        return creditCards;
    }

    // you can create an empty wallet and add a credit card whenever using this method.

    public void addCreditCard(CreditCard creditCard) {
        creditCards.add(creditCard);
    }

    // uses the calculator object to return the total interest amount for this wallet.

    public double getWalletTotalInterest() {
        double walletTotal = 0;

        for (CreditCard creditCard : creditCards) {
            walletTotal += creditCard.getInterestPayment();
        }
        return walletTotal;
    }
}

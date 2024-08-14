package com.vernite.cal.controller;


import java.util.ArrayList;

public class Customer {

    private final ArrayList<Wallet> wallets = new ArrayList<>();

    // a customer can add a wallet to their collection of wallets as well as get them.

    public void addWallet(Wallet wallet) {
        wallets.add(wallet);
    }

    public ArrayList<Wallet> getWallets() {
        return wallets;
    }

    // this method instantiates the calculator object to get the total interest amount for each wallet
    // then adds each wallet together to find the sum of all of the wallets in a person's collection.

    public double getWalletsTotalInterest() {
        double total = 0;

        for (Wallet wallet : wallets) {
            total += wallet.getWalletTotalInterest();
        }

        return  total;
    }
}

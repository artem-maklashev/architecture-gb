package org.HW4.Models;

import javax.smartcardio.Card;

/**
 * Модель банковского аккаунта
 */
public class BankAccount {

    private int balance;
    private Card card;


    public BankAccount() {
        balance = 1000;
    }

    @Override
    public String toString() {
        return "BankAccount {" +
                " card= " + (String.format("%016d", card)) +
                ", balance= " + balance +
                " }";
    }
}

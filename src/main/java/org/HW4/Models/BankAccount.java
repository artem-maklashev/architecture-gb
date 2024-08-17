package org.HW4.Models;

import javax.smartcardio.Card;

/**
 * Модель банковского аккаунта
 */
public class BankAccount {

    private int balance;
    private Long card;


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

    public long getCard() {
        return card;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int i) {
        balance = i;
    }
}

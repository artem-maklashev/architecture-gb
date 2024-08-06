package org.example.abstractfactory;


public class AdultSet implements Birthdayfactory{
    public Gift getGift() {
        return new AdultGift();
    }

    public Card getCard() {
        return new AdultCard();
    }

    public Cake getCake() {
        return new AdultCake();
    }

}

package org.example.abstractfactory;

public class KidsSet implements Birthdayfactory{
    public Gift getGift() {
        return new KidsGift();
    }

    public Card getCard() {
        return new KidsCard();
    }

    public Cake getCake() {
        return new KidsCake();
    }
}

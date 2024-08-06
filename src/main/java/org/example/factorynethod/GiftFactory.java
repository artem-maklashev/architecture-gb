package org.example.factorynethod;

public class GiftFactory {

    public Gift createGift(int age){
        if(age<18){
            return new KidsGift();
        }
        return new AdultGift();
    }
}

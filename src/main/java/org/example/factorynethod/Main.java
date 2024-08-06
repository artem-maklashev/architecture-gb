package org.example.factorynethod;

public class Main {

    public static void main(String[] args) {
        Gift gift = new GiftFactory().createGift(15);
        System.out.println(gift.getName());
        Gift gift2 = new GiftFactory().createGift(25);
        System.out.println(gift2.getName());
    }
}

package org.example.singleton;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance(); //1
        Singleton singleton2 = Singleton.getInstance(); //2
        System.out.println(singleton == singleton2); //true
        System.out.println(singleton.hashCode()); //1
        System.out.println(singleton2.hashCode()); //1
    }
}

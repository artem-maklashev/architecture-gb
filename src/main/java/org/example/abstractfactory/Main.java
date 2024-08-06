package org.example.abstractfactory;

public class Main {
    public static void main(String[] args) {
        AdultSet set = new AdultSet();
        System.out.println(doGift(set));

        KidsSet set2 = new KidsSet();
        System.out.println(doGift(set2));
    }

    public static String doGift(Birthdayfactory set){
        return  set.getGift().getName() + " & " + set.getCake().getName() + " & " + set.getCard().getName();
    }
}

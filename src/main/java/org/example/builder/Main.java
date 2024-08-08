package org.example.builder;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder()
                .topping1("pepperoni")
                .topping2("tomato")
                .build();

        System.out.println(pizza.topping1);
        System.out.println(pizza.topping2);
        System.out.println(pizza.topping3);
        System.out.println(pizza.topping4);

    }
}

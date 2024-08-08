package org.example.builder;

public class Pizza {
    String topping1;
    String topping2;
    String topping3;
    String topping4;

    public Pizza() {
    }

    public static class PizzaBuilder {

        private final Pizza pizza;

        PizzaBuilder(){
            pizza = new Pizza();
        }

        public PizzaBuilder topping1(String topping1){
            pizza.topping1 = topping1;
            return this;
        }

        public PizzaBuilder topping2(String topping2){
            pizza.topping2 = topping2;
            return this;
        }

        public PizzaBuilder topping3(String topping3){
            pizza.topping3 = topping3;
            return this;
        }

        public Pizza topping4(String topping4){
            pizza.topping4 = topping4;
            return pizza;
        }
        public Pizza build(){
            return pizza;
        }
    }
}

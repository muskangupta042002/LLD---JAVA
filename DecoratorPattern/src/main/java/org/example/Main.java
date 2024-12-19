package org.example;

public class Main {
    public static void main(String[] args) {

        Beverage beverage= new Decaf();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new DarkRoast();
        beverage1.setSize(Beverage.Size.VENTI);
        beverage1 = new Soy(beverage1);
        beverage1 = new Milk(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());



    }

}
/*
Decaf Coffee $1.05
Dark Roast,Soy, Milk $99.3
 */
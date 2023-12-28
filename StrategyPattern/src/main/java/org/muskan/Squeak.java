package org.muskan;

public class Squeak implements  QuackBehavior{
    public void quack(){
        System.out.println("Squeak");
    }
}
/**

The code you provided demonstrates the use of some of the four pillars of object-oriented programming (OOP): encapsulation, inheritance, and polymorphism. However, it does not explicitly demonstrate the fourth pillar, which is abstraction.

Here's how the pillars are applied in your code:

Encapsulation:

The Duck class encapsulates the behaviors (fly and quack) by using interfaces (FlyBehavior and QuackBehavior) and composition (having flyBehavior and quackBehavior as instance variables).
Inheritance:

The MallardDuck class extends the abstract class Duck, demonstrating inheritance.
Polymorphism:

Polymorphism is demonstrated through the use of interfaces (FlyBehavior and QuackBehavior) and the implementation of those interfaces by classes like FlyWithWings, FlyWithNoWay, Quack, MuteQuack, and Squeak. The performQuack and performFly methods in the Duck class are polymorphic because they can work with any class that implements the corresponding interface.
**/

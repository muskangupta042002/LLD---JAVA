package org.muskan;

public class FlyWithNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I cant fly!!");
    }
}

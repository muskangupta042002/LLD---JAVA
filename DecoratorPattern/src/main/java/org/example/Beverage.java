package org.example;

public abstract class Beverage {
    public enum Size{ TALL, GRANDE, VENTI };
    Size size = Size.TALL;
    String description = "Unknown Bevarage";
    public String getDescription(){
        return description;
    }

    public Size getSize(){
        return this.size;
    }

    public void setSize(Size size){
        this.size=size;
    }

    public abstract double cost();
}

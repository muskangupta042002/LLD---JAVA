package org.muskan;

public class PopcornPopper {
    String description;

    public PopcornPopper(String description) {
        this.description = description;
    }

    public void on(){
        System.out.println(description + " turn on");
    }

    public void off(){
        System.out.println(description + " turn off");
    }

    public void pop(){
        System.out.println(description + " popping up");
    }

    @Override
    public String toString() {
        return description ;
    }
}

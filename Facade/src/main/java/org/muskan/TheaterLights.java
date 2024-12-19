package org.muskan;

public class TheaterLights {
    String description;

    public TheaterLights(String description) {
        this.description = description;
    }

    public void on(){
        System.out.println(description + " turn on");
    }

    public void off(){
        System.out.println(description + " turn off");
    }

    public void dim(){
        System.out.println(description + " dimming light");
    }

    @Override
    public String toString() {
        return description ;
    }
}

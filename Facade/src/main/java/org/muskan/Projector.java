package org.muskan;

public class Projector {
    StreamingPlayer player;

    String description;

    public Projector(String description, StreamingPlayer player) {
        this.description = description;
        this.player = player;
    }

    public void on(){
        System.out.println(description + " turn on");
    }

    public void off(){
        System.out.println(description + " turn off");
    }

    public void wideScreenMode() {
        System.out.println(description + " in widescreen mode (16x9 aspect ratio)");
    }

    public void tvMode() {
        System.out.println(description + " in tv mode (4x3 aspect ratio)");
    }

    @Override
    public String toString() {
        return description ;
    }
}

package org.muskan;

public class Screen {

    String description;

    public Screen(String description) {
        this.description = description;
    }

    public void up(){
        System.out.println(description + " going up");
    }

    public void down(){
        System.out.println(description + " going up");
    }

    @Override
    public String toString() {
        return description ;
    }
}

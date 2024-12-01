package org.muskan;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<>();

    public String getName() {
        return name;
    }

    public  void prepare(){
        System.out.println("Preparing " + name);
    }

    void bake() {
        System.out.println(" Baking " + name);
    }

    void cut(){
        System.out.println("Cutting " + name);
    }

    void box() {
        System.out.println("Boxing " + name);
    }

    public String toString(){
        StringBuffer display = new StringBuffer();
        display.append("--- " + name + "-----\n");
        display.append(dough + "\n");
        display.append(sauce + "\n");
        for(String topping: toppings){
            display.append(topping + "\n");
        }
        return display.toString();
    }

}

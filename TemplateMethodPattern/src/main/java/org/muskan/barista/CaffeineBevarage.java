package org.muskan.barista;

abstract public class CaffeineBevarage {

    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()){
            addCondiments();
        }
    }
    abstract void brew();
    abstract void addCondiments();

    void boilWater(){
        System.out.println("Boiling water !!!");
    }

    void pourInCup(){
        System.out.println("Pouring into Cup!!");
    }

    boolean customerWantsCondiments(){
        return true;
    }
}

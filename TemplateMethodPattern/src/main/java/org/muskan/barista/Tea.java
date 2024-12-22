package org.muskan.barista;

public class Tea  extends CaffeineBevarage{
    @Override
    void brew() {
        System.out.println("Steeping the tea..");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon...");
    }
}

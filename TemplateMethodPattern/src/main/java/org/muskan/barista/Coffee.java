package org.muskan.barista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coffee extends CaffeineBevarage{
    @Override
    void brew() {
        System.out.println("Dripping coffee through filter..");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and Milk");
    }
    public boolean customerWantsCondiments(){
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) return true;
        return false;
    }

    public String getUserInput(){
        String answer = null;
        System.out.println("Would ou like milk and sugar with your coffee (y/n) ? ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try{
            answer = in.readLine();

        }catch (IOException ex){
            System.err.println("IO error trying to read your answer");
        }
        if(answer==null) return "no";
        return answer;
    }
}

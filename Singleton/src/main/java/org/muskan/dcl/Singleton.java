package org.muskan.dcl;

public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {}

    public static Singleton getInstance(){
        if(uniqueInstance == null){
            synchronized (Singleton.class){
                if(uniqueInstance == null){
                    uniqueInstance = new Singleton();
                    System.out.println("creating new instance");
                }
            }
        }
        return uniqueInstance;
    }
}

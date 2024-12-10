package org.muskan.dcl;

public class SingletonClient {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        Singleton singleton1 = Singleton.getInstance();
    }
}

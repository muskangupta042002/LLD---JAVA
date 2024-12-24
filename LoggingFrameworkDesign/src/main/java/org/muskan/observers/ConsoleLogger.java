package org.muskan.observers;


public class ConsoleLogger implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("CONSOLE: "+message);
    }
}

package org.muskan.observers;

import org.muskan.observers.LogObserver;

public class FileLogger implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("FILE: "+message);
    }
}
//observer
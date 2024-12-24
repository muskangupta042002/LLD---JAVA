package org.muskan.levels;

import org.muskan.levels.AbstractLogger;
import org.muskan.subject.LogSubject;

public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void display(String message, LogSubject logSubject) {
        String msg= ("Error: "+message);
        logSubject.notifyObservers(this.level, msg);
    }
}

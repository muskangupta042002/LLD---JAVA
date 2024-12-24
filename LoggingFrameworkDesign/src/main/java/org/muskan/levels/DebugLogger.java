package org.muskan.levels;

import org.muskan.levels.AbstractLogger;
import org.muskan.subject.LogSubject;

public class DebugLogger extends AbstractLogger {
    public DebugLogger(int level){
        this.level = level;
    }

    @Override
    protected void display(String message, LogSubject logSubject) {
        String msg = ("Debug: "+message);
        logSubject.notifyObservers(this.level, msg);
    }
}

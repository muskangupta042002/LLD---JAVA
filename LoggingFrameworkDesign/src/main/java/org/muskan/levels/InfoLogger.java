package org.muskan.levels;

import org.muskan.levels.AbstractLogger;
import org.muskan.subject.LogSubject;

public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level){
        this.level = level;
    }

    @Override
    protected void display(String message, LogSubject logSubject) {
        String msg = "INFO: "+message;
        logSubject.notifyObservers(this.level, msg);
    }
}

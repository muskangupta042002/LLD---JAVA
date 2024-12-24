package org.muskan.levels;

import lombok.Data;
import org.muskan.subject.LogSubject;

@Data
public abstract class AbstractLogger {
    int level;
    AbstractLogger nextLoggingLevel;
    public void logMessage(int level, String message, LogSubject logSubject){
        if(this.level <= level){
            display(message, logSubject);
        }
        if(nextLoggingLevel != null){
            nextLoggingLevel.logMessage(level, message, logSubject);
        }
    }
    protected abstract void display(String message, LogSubject logSubject);
}

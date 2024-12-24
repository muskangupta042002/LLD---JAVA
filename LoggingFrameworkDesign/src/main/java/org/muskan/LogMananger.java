package org.muskan;

import org.muskan.levels.AbstractLogger;
import org.muskan.levels.DebugLogger;
import org.muskan.levels.ErrorLogger;
import org.muskan.levels.InfoLogger;
import org.muskan.observers.ConsoleLogger;
import org.muskan.observers.FileLogger;
import org.muskan.subject.LogSubject;

public class LogMananger {
    protected static AbstractLogger buildChainOfLogger(){
        AbstractLogger infoLogger = new InfoLogger(1);
        AbstractLogger errorLogger = new ErrorLogger(2);
        AbstractLogger debugLogger = new DebugLogger(3);

        infoLogger.setNextLoggingLevel(errorLogger);
        errorLogger.setNextLoggingLevel(debugLogger);
        return  infoLogger;
    }

    protected  static LogSubject buildSubject(){
        LogSubject logSubject = new LogSubject();
        ConsoleLogger consoleLogger=new ConsoleLogger();
        FileLogger fileLogger = new FileLogger();
        logSubject.addObserver(1, consoleLogger); //add info in console
        logSubject.addObserver(2, fileLogger); //add error in file
        return logSubject;
    }
}

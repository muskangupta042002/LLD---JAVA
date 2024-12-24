package org.muskan;

import org.muskan.levels.AbstractLogger;
import org.muskan.subject.LogSubject;

import java.io.Serializable;

import static org.muskan.LogMananger.buildChainOfLogger;
import static org.muskan.LogMananger.buildSubject;

public class Logger implements Cloneable, Serializable {
    private volatile static Logger uniqueInstance;
    private volatile static AbstractLogger chainOfLogger;

    //to add and notify observers
    private volatile static LogSubject logSubject;
    private Logger() throws IllegalAccessException {
        if(uniqueInstance != null){
            throw new IllegalAccessException("object already exists");
        }
    }

    public static Logger getInstance() throws IllegalAccessException {
        if(uniqueInstance == null){
            synchronized (Logger.class){
                if(uniqueInstance == null){
                    uniqueInstance = new Logger();
                    chainOfLogger = buildChainOfLogger();
                    logSubject = buildSubject();
                    System.out.println("creating new instance");
                }
            }
        }
        return uniqueInstance;
    }

    protected Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
    protected Object readResolve(){
        return uniqueInstance;
    }

    public void createLog(int level, String msg){
        chainOfLogger.logMessage(level, msg, logSubject);
    }

    public void info(String msg){
        createLog(1, msg);
    }

    public void error(String msg){
        createLog(2, msg);
    }

    public void debug(String msg){
        createLog(3, msg);
    }
}

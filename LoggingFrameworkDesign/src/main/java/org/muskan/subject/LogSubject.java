package org.muskan.subject;

import org.muskan.observers.LogObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSubject {
    //List<LogObserver> logObservers = new ArrayList<>();
    Map<Integer,  List<LogObserver>> logObservers = new HashMap<>();

    public void addObserver(int level, LogObserver logObserver){
        List<LogObserver> logObserversList = logObservers.getOrDefault(level, new ArrayList<>());
        logObserversList.add(logObserver);
        logObservers.put(level, logObserversList);
    }

    public void notifyObservers(int level, String msg){
        for(Map.Entry<Integer, List<LogObserver>> entry: logObservers.entrySet()){
            if(entry.getKey() == level){
                entry.getValue().forEach(observer -> observer.log(msg));
            }
        }
    }
}

package org.muskan.services;

import org.muskan.reservations.VehicleReservation;

import java.util.List;
import java.util.ArrayList;
public class NotificationManager {
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void notifyObservers(VehicleReservation reservation){
        for(Observer observer: observers){
            observer.update(reservation);
        }
    }
}

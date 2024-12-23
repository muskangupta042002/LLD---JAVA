package org.muskan.services;

import org.muskan.reservations.VehicleReservation;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class NotificationService {
    private Timer timer;
    public NotificationService(){
        this.timer=new Timer();
    }
    public void setReservationRemainder(VehicleReservation reservation){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Reminder: Your reservation is approaching! Pickup date: " + reservation.getDueDate());
            }
        },reservation.getDueDate());
    }

    public void sendLateReturnRemainder(VehicleReservation reservation){
        long delay = new Date().getTime() - reservation.getDueDate().getTime();
        if(delay>0){
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Reminder: You are late in returning the vehicle. Please return it as soon as possible.");
                }
            }, delay);
        }
    }
}

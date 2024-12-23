package org.muskan.services;

import org.muskan.accounts.Member;
import org.muskan.reservations.VehicleReservation;
import org.muskan.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationManager {
    private List<VehicleReservation> reservations;
    public ReservationManager(){
        reservations = new ArrayList<>();
    }
    public VehicleReservation bookVehicle(Member member, Vehicle vehicle, Date dueDate){
        VehicleReservation reservation = new VehicleReservation(reservations.size()+1, member, vehicle, dueDate);
        reservations.add(reservation);
        member.addReservation(reservation);
        return  reservation;
    }

    public boolean cancelReservation(int reservationId){
        for(VehicleReservation reservation: reservations){
            if(reservation.getReservationId() == reservationId){
                reservations.remove(reservation);
                return true;
            }
        }
        return false;

    }

    public boolean returnVehicle(int reservationId) {
        // Logic for returning a vehicle
        return true;
    }
}

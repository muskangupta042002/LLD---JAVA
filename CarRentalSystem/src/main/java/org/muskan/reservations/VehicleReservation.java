package org.muskan.reservations;

import lombok.Data;
import org.muskan.accounts.Member;
import org.muskan.vehicles.Vehicle;

import java.util.Date;

@Data
public class VehicleReservation {
    private int reservationId;
    private Member member;
    private Vehicle vehicle;
    private Date reservationDate;
    private Date dueDate;

    public VehicleReservation(int reservationId, Member member, Vehicle vehicle, Date dueDate) {
        this.reservationId = reservationId;
        this.member = member;
        this.vehicle = vehicle;
        this.reservationDate = new Date();
        this.dueDate = dueDate;
    }

}

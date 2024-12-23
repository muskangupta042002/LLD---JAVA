package org.muskan.accounts;

import lombok.Data;
import org.muskan.reservations.VehicleReservation;

import java.util.ArrayList;
import java.util.List;

@Data
public class Member {
    private int memberId;
    private String name;
    private String email;
    private List<VehicleReservation> reservations;
    public Member(int memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.reservations = new ArrayList<>();
    }

    public void addReservation(VehicleReservation reservation){
        reservations.add(reservation);
    }


}

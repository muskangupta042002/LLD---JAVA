package org.muskan;

import org.muskan.accounts.Member;
import org.muskan.common.PaymentStatus;
import org.muskan.common.VehicleType;
import org.muskan.reservations.VehicleReservation;
import org.muskan.search.VehicleInventory;
import org.muskan.services.AdditionalServices;
import org.muskan.services.NotificationService;
import org.muskan.services.PaymentService;
import org.muskan.services.ReservationManager;
import org.muskan.vehicles.Truck;
import org.muskan.vehicles.Car;
import org.muskan.vehicles.Vehicle;

import java.util.Date;
import java.util.List;

//public class RentalServiceDriver {
//    public static void main(String[] args) {
//        VehicleInventory vehicleInventory = new VehicleInventory();
//        NotificationService notificationService = new NotificationService();
//        PaymentService paymentService = new PaymentService();
//        AdditionalServices additionalServices = new AdditionalServices();
//        ReservationManager reservationManager = new ReservationManager();
//        //Create Vehicles
//        Member member = new Member(0, "Muskan Gupta","muskan@example.com");
//
//
//        //Book a vehicle
//        Vehicle vehicle = vehicleInventory.serachByType(VehicleType.CAR).get(1);
//        Date dueDate = new Date(System.currentTimeMillis() + (7 * 24 * 60 * 60 * 1000));
//        VehicleReservation reservation = reservationManager.bookVehicle(member, vehicle, dueDate);
//        member.addReservation(reservation);
//        // Send reminder for upcoming reservation
//        notificationService.setReservationRemainder(reservation);
//
//        // Add additional services
//        additionalServices.addInsurance(reservation);
//        additionalServices.addRoadsideAssistance(reservation);
//        additionalServices.addWifi(reservation);
//
//        // Process payment
//        PaymentStatus paymentStatus = paymentService.processPayment(reservation, true);
//
//        if(paymentStatus == PaymentStatus.PAID) {
//            System.out.println("Reservation confirmed!");
//        }
//
//        // Handle vehicle return after due date
//        notificationService.sendLateReturnRemainder(reservation);
//    }
//}
public class RentalServiceDriver {
    public static void main(String[] args) {
        VehicleInventory vehicleInventory = new VehicleInventory();
        NotificationService notificationService = new NotificationService();
        PaymentService paymentService = new PaymentService();
        AdditionalServices additionalServices = new AdditionalServices();
        ReservationManager reservationManager = new ReservationManager();

        // Add vehicles to inventory
        vehicleInventory.addVehicle(new Car("KA01AB1234", "Hyundai i20"));
        vehicleInventory.addVehicle(new Truck("KA02XY5678", "Tata Ace"));

        // Create a member
        Member member = new Member(0, "Muskan Gupta", "muskan@example.com");

        // Search for a vehicle by type
        List<Vehicle> availableCars = vehicleInventory.serachByType(VehicleType.CAR);
        if (availableCars.isEmpty()) {
            System.out.println("No vehicles of the selected type are available.");
            return;
        }

        // Book a vehicle
        Vehicle vehicle = availableCars.get(0); // Use the first available vehicle
        Date dueDate = new Date(System.currentTimeMillis() + (7 * 24 * 60 * 60 * 1000));
        VehicleReservation reservation = reservationManager.bookVehicle(member, vehicle, dueDate);

        // Send reminder for upcoming reservation
        notificationService.setReservationRemainder(reservation);

        // Add additional services
        additionalServices.addInsurance(reservation);
        additionalServices.addRoadsideAssistance(reservation);
        additionalServices.addWifi(reservation);

        // Process payment
        PaymentStatus paymentStatus = paymentService.processPayment(reservation, true);
        if (paymentStatus == PaymentStatus.PAID) {
            System.out.println("Reservation confirmed!");
        }

        // Handle vehicle return after due date
        notificationService.sendLateReturnRemainder(reservation);
    }
}

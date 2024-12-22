package org.muskan;

import org.muskan.payment.DebitCard;
import org.muskan.payment.PaymentProcessor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class RentalSystem {

    private static RentalSystem instance; //holds the singleton instance so it can be shared across the class and access without creating objects
    private final Map<String, Car> cars; //store cars by their unique license plates

    private final Map<String, Reservation> reservations; //manage reservations by their unique reservation IDs

    private final PaymentProcessor paymentProcessor;
    private RentalSystem(){
        cars = new ConcurrentHashMap<>(); //to handle concurrent access
        reservations = new ConcurrentHashMap<>();
        paymentProcessor = new DebitCard();
    }

    public static synchronized RentalSystem getInstance(){
        //synchronized keyword ensures that multiple threads don’t create separate instances in a multi-threaded environment.
        if(instance==null){
            instance = new RentalSystem();
            // lazy initialization
        }
        return instance;
    }

    public void addCar(Car car){
        cars.put(car.getLicensePlate(), car);
    }

    public void removeCar(String licensePlate){
        cars.remove(licensePlate);
    }

    private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate){
        for(Reservation reservation: reservations.values()){
            if(reservation.getCar().equals(car)){
                if(startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate())){
                    return false;
                }
            }
        }
        return true;
    }

    public List<Car> searchCars(String make, String model, LocalDate startDate, LocalDate endDate){
        List<Car> availableCars = new ArrayList<>();
        for(Car car: cars.values()){
            if (car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model) ) {
                if (isCarAvailable(car, startDate, endDate)) {
                    availableCars.add(car);
                }
            }
        }
        return availableCars;
    }

    public boolean processPayment(Reservation reservation){
        return paymentProcessor.paymentMode(reservation.getTotalPrice());
    }

    public synchronized void cancelReservation(String reservationId){
        Reservation reservation = reservations.remove(reservationId);
        if (reservation != null){
            reservation.getCar().setAvailable(true);
        }
    }

    private String generateReservationId() {
        return "RES" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
        //Generates a unique reservation ID using a random UUID. The first 8 characters are used for simplicity.
    }

    public synchronized Reservation makeReservation(Customer customer, Car car, LocalDate startDate, LocalDate endDate){
        if (isCarAvailable(car, startDate, endDate)){
            String reservationId = generateReservationId();
            Reservation reservation = new Reservation(reservationId,customer,car,startDate,endDate);
            reservations.put(reservationId, reservation);
            car.setAvailable(false);
            return  reservation;
        }
        return null;
    }
}

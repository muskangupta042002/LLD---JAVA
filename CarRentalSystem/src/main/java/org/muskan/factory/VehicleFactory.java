package org.muskan.factory;

import org.muskan.vehicles.Car;
import org.muskan.common.VehicleType;
import org.muskan.vehicles.Truck;
import org.muskan.vehicles.Vehicle;

public interface VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, String vehicleNumber, String model){
        switch (type){
            case CAR:
                return new Car(vehicleNumber,model);
            case TRUCK:
                new Truck(vehicleNumber, model);
                // Add more cases for other vehicle types
            default:
                throw new IllegalArgumentException("Unsupported vehicle type");
        }
    }
}

package org.muskan.vehicles;

import org.muskan.common.VehicleType;

public class Car extends Vehicle{

    public Car(String vehicleNumber, String model){
        super(vehicleNumber,model,VehicleType.CAR);
    }
    @Override
    public double calculateRentalPrice() {
        return 770;
    }
}

package org.muskan.factory;

import org.muskan.Car;

public interface CarFactory {
    Car createCar(String make, String model, int year, String licensePlate, double rentalPrice);
}

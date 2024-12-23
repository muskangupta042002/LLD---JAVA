package org.muskan.search;

import org.muskan.common.VehicleType;
import org.muskan.vehicles.Vehicle;

import java.util.List;

public interface Search {
    List<Vehicle> serachByType(VehicleType type);
    List<Vehicle> serachByModel(String model);
}

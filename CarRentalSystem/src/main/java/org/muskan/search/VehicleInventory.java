package org.muskan.search;

import org.muskan.common.VehicleType;
import org.muskan.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class VehicleInventory implements Search {
    private Map<VehicleType, List<Vehicle>> inventoryByType;
    private Map<String, List<Vehicle>> inventoryByModel;

    public VehicleInventory(){
        inventoryByModel = new ConcurrentHashMap<>();
        inventoryByType = new ConcurrentHashMap<>();
    }

    public void addVehicle(Vehicle vehicle){
        inventoryByModel.computeIfAbsent(vehicle.getModel(), k->new ArrayList<>()).add(vehicle);
        inventoryByType.computeIfAbsent(vehicle.getType(), k->new ArrayList<>()).add(vehicle);
    }
    @Override
    public List<Vehicle> serachByType(VehicleType type) {
        return inventoryByType.getOrDefault(type, new ArrayList<>());
    }

    @Override
    public List<Vehicle> serachByModel(String model) {
        return inventoryByModel.getOrDefault(model, new ArrayList<>());
    }
}

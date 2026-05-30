package LLD.Parking.strategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

import LLD.Parking.enums.VehicleType;
import LLD.Parking.model.ParkingSpot;

public class ParkingRepository {
private final Map<VehicleType,ConcurrentLinkedQueue<ParkingSpot>> parkingSpotbyVehicle;

    ParkingRepository(){
        this.parkingSpotbyVehicle = new HashMap<>();
    }

    public void addParkingSpot(VehicleType type,ParkingSpot spot){
        parkingSpotbyVehicle.computeIfAbsent(type,k->new ConcurrentLinkedQueue<>()).add(spot);
    }

    public ConcurrentLinkedQueue<ParkingSpot> getSpotsByVehicleType(VehicleType type){
        return parkingSpotbyVehicle.getOrDefault(type,new ConcurrentLinkedQueue<>());
    }
}

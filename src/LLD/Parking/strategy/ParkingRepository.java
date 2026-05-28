package LLD.Parking.strategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import LLD.Parking.enums.VehicleType;
import LLD.Parking.model.ParkingSpot;

class ParkingRepository {
private final Map<VehicleType,List<ParkingSpot>> parkingSpotbyVehicle;

    ParkingRepository(){
        this.parkingSpotbyVehicle = new HashMap<>();
    }

    public void addParkingSpot(VehicleType type,ParkingSpot spot){
        parkingSpotbyVehicle.computeIfAbsent(type,k->new ArrayList<>()).add(spot);
    }

    public List<ParkingSpot> getSpotsByVehicleType(VehicleType type){
        return parkingSpotbyVehicle.getOrDefault(type,Collections.emptyList());
    }
}

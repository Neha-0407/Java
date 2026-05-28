package LLD.Parking.strategy;

import java.util.List;

import LLD.Parking.enums.ParkingSpotStatus;
import LLD.Parking.model.ParkingSpot;
import LLD.Parking.model.Vehicle;


public class NearestAllocationStrategy implements ParkingSpotAllocationStrategy {

    private final ParkingRepository parkingRepository;

    NearestAllocationStrategy(ParkingRepository parkingRepository){
        this.parkingRepository = parkingRepository;
    }

    @Override
    public ParkingSpot allocateParkingSpot(Vehicle vehicle) {
       List<ParkingSpot> parkingSpots = parkingRepository.getSpotsByVehicleType(vehicle.getVehicleType());
       for(ParkingSpot spot : parkingSpots){
            if(spot.getParkingSpotStatus() == ParkingSpotStatus.VACANT){
                spot.setCurrentVehicle(vehicle);
                spot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
                return spot;
            }
        }
        throw new RuntimeException("No parking spot available for vehicle type: " + vehicle.getVehicleType());
    }
    
}

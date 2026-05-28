package LLD.Parking.strategy;

import LLD.Parking.model.ParkingSpot;
import LLD.Parking.model.Vehicle;

public interface ParkingSpotAllocationStrategy {
    ParkingSpot allocateParkingSpot(Vehicle vehicle);
}

package LLD.Parking.model;

import java.util.concurrent.locks.ReentrantLock;

import LLD.Parking.enums.ParkingSpotStatus;
import LLD.Parking.enums.ParkingSpotType;

public class ParkingSpot {
    private final String spotId;
    private ParkingSpotType parkingSpotType;
    private ParkingSpotStatus parkingSpotStatus;
    private Vehicle currentVehicle;
    private double hourlyRate;
    private final ReentrantLock lock;

    ParkingSpot(String spotId, ParkingSpotType parkingSpotType, double hourlyRate){
        this.spotId = spotId;
        this.parkingSpotType = parkingSpotType;
        this.hourlyRate = hourlyRate;
        this.parkingSpotStatus = ParkingSpotStatus.VACANT;
        this.lock = new ReentrantLock();
    }

    public boolean tryAndAssignLock(Vehicle vehicle){
        lock.lock();
        try{
            if(this.parkingSpotStatus == ParkingSpotStatus.OCCUPIED)
                return false;   
            this.parkingSpotStatus = ParkingSpotStatus.OCCUPIED;
            this.currentVehicle = vehicle; // This will be set by the allocation strategy after acquiring the lock
        }finally{
            lock.unlock();
        }
        return true;
    }
    public void releaseLock(){
        lock.lock();
        try{
            this.parkingSpotStatus = ParkingSpotStatus.VACANT;
            this.currentVehicle = null; 
        }finally{
            lock.unlock();
        }
    }
    public String getSpotId() {
        return spotId;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }
    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }
    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }
    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }
    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }
    public void setCurrentVehicle(Vehicle currentVehicle) {
        this.currentVehicle = currentVehicle;
    }
    public double getHourlyRate() {
        return hourlyRate;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public void removeVehicle(){
        this.currentVehicle = null;
        this.parkingSpotStatus = ParkingSpotStatus.VACANT;
    }
}

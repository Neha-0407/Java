package LLD.Parking.model;

import LLD.Parking.enums.ParkingSpotStatus;
import LLD.Parking.enums.ParkingSpotType;

public class ParkingSpot {
    String spotId;
    ParkingSpotType parkingSpotType;
    ParkingSpotStatus parkingSpotStatus;
    Vehicle currentVehicle;
    double hourlyRate;

    ParkingSpot(String spotId, ParkingSpotType parkingSpotType, double hourlyRate){
        this.spotId = spotId;
        this.parkingSpotType = parkingSpotType;
        this.hourlyRate = hourlyRate;
        this.parkingSpotStatus = ParkingSpotStatus.VACANT;
    }
    public String getSpotId() {
        return spotId;
    }
    public void setSpotId(String spotId) {
        this.spotId = spotId;
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

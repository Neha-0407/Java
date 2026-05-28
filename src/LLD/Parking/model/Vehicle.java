package LLD.Parking.model;
import LLD.Parking.enums.VehicleType;

public class Vehicle {
    VehicleType vehicleType;
    String licensePlate;
    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    
}

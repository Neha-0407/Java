package LLD.Parking.model;


import LLD.Parking.enums.TicketStatus;

public class Ticket {
    String ticketId;
    ParkingSpot parkingSpot;
    Vehicle vehicle;
    long entryTime;
    long exitTime;
    TicketStatus ticketStatus;

    public String getTicketId() {
        return ticketId;
    }
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public long getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }
    public long getExitTime() {
        return exitTime;
    }
    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }
    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }
    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
    public void closeTicket(){
        this.exitTime = System.currentTimeMillis();
        this.ticketStatus = TicketStatus.CLOSED;
    }

    


}

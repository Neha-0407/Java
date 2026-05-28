package LLD.Parking.services;

import java.util.UUID;

import LLD.Parking.enums.ParkingSpotType;
import LLD.Parking.enums.TicketStatus;
import LLD.Parking.model.Ticket;
import LLD.Parking.model.Vehicle;
import LLD.Parking.model.ParkingSpot;

public class TicketService {
    Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot){
        Ticket ticket = new Ticket();
        ticket.setTicketId(UUID.randomUUID().toString());
        ticket.setVehicle(vehicle);
        ticket.setParkingSpot(parkingSpot);
        ticket.setEntryTime(System.currentTimeMillis());
        ticket.setTicketStatus(TicketStatus.ACTIVE);
        return ticket;
    }
}

package LLD.Parking.services;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import LLD.Parking.model.Ticket;
import LLD.Parking.model.Vehicle;
import LLD.Parking.enums.ParkingSpotStatus;
import LLD.Parking.enums.TicketStatus;
import LLD.Parking.model.ParkingSpot;

import LLD.Parking.strategy.NearestAllocationStrategy;
import LLD.Parking.strategy.ParkingSpotAllocationStrategy;
import LLD.Parking.strategy.PaymentService;

public class ParkingService {


    private ParkingSpotAllocationStrategy parkingSpotAllocationStrategy;
    private TicketService ticketService;
    private PaymentService paymentService;
    ParkingService(ParkingSpotAllocationStrategy parkingSpotAllocationStrategy, TicketService ticketService, PaymentService paymentService){
        this.parkingSpotAllocationStrategy = parkingSpotAllocationStrategy;
        this.ticketService = ticketService;
        this.paymentService = paymentService;
    }
    public Ticket parkVehicle(Vehicle vehicle){
        ParkingSpot parkingSpot = parkingSpotAllocationStrategy.allocateParkingSpot(vehicle);
        if(parkingSpot != null){
            return ticketService.generateTicket(vehicle, parkingSpot);
        }
        return null;
    }
    public void unparkVehicle(Ticket ticket){
        ticket.closeTicket();
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.removeVehicle();
        paymentService.processPayment(ticket);
    }

}

package LLD.Parking.strategy;

import java.time.Duration;

import LLD.Parking.model.Ticket;

public class HourlyPaymentStrategy implements PaymentStrategy {

    @Override
    public double calculateFee(Ticket ticket) {
        long hoursParked = System.currentTimeMillis() - ticket.getEntryTime();
        return hoursParked * ticket.getParkingSpot().getHourlyRate()/(60*60*1000);
    }
    
}

package LLD.Parking.strategy;

import LLD.Parking.model.Ticket;

public interface PaymentStrategy {
    public double calculateFee(Ticket ticket);
}

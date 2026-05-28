package LLD.Parking.strategy;

import LLD.Parking.enums.PaymentStatus;
import LLD.Parking.model.Ticket;

public interface PaymentService {
    PaymentStatus processPayment(Ticket ticket);
}

package LLD.Parking.services;

import LLD.Parking.enums.PaymentStatus;
import LLD.Parking.model.Ticket;
import LLD.Parking.strategy.PaymentService;
import LLD.Parking.strategy.PaymentStrategy;

public class PaymentServiceImpl implements PaymentService {

    private final PaymentStrategy paymentStrategy;
    PaymentServiceImpl(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
        
    @Override
    public PaymentStatus processPayment(Ticket ticket) {
        double fee = paymentStrategy.calculateFee(ticket);
        return PaymentStatus.SUCCESS; // In real implementation, this would involve actual payment processing logic
    }
    
}

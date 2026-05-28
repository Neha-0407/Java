package LLD.Parking;

import LLD.Parking.enums.VehicleType;
import LLD.Parking.model.Ticket;
import LLD.Parking.model.Vehicle;
import LLD.Parking.services.ParkingService;
import LLD.Parking.services.TicketService;
import LLD.Parking.strategy.HourlyPaymentStrategy;
import LLD.Parking.strategy.NearestAllocationStrategy;
import LLD.Parking.strategy.ParkingRepository;
import LLD.Parking.strategy.ParkingSpotAllocationStrategy;
import LLD.Parking.strategy.PaymentService;
import LLD.Parking.strategy.PaymentServiceImpl;
import LLD.Parking.strategy.PaymentStrategy;

public class main {
    ParkingRepository repository = new ParkingRepository();

    repository.addParkingSpot(
                VehicleType.CAR,
                new ParkingSpot(
                        "C1",
                        VehicleType.CAR,
                        20
                )
        );

        ParkingSpotAllocationStrategy strategy =
                new NearestAllocationStrategy(
                        repository
                );

        TicketService ticketService =
                new TicketService();

        PaymentStrategy paymentStrategy =
                new HourlyPaymentStrategy();

        PaymentService paymentService =
                new PaymentService(paymentStrategy);

        ParkingService parkingService =
                new ParkingService(
                        strategy,
                        ticketService,
                        paymentService
                );

        Vehicle vehicle =
                new Vehicle(
                        "MH12AB1234",
                        VehicleType.CAR
                );

        Ticket ticket =
                parkingService.parkVehicle(vehicle);

        double amount =
                parkingService.unparkVehicle(ticket);

        System.out.println(amount);
    }
}

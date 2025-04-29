package Examples.AirlineManagementSystem;

import Examples.AirlineManagementSystem.entities.aircraft.Aircraft;
import Examples.AirlineManagementSystem.entities.booking.payment.Payment;
import Examples.AirlineManagementSystem.entities.flight.State.Flight;
import Examples.AirlineManagementSystem.entities.booking.State.Booking;
import Examples.AirlineManagementSystem.entities.user.*;
import Examples.AirlineManagementSystem.service.FlightSearchService;
import Examples.AirlineManagementSystem.filter.FilterSystem;
import Examples.AirlineManagementSystem.filter.Filters;
import Examples.AirlineManagementSystem.entities.flight.Airport;
import Examples.AirlineManagementSystem.entities.aircraft.Seat;
import Examples.AirlineManagementSystem.entities.enums.SeatType;
import Examples.AirlineManagementSystem.notifier.Notifier;
import Examples.AirlineManagementSystem.service.Booking.BookingService;
import Examples.AirlineManagementSystem.service.payment.CashPayment;
import Examples.AirlineManagementSystem.service.payment.CreditCardPayment;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    // Admin will :
    // Create a Flight
    // Assign available crew
    // Delay, Cancel and reschedule the flight
    // Admin should be able to cancel the flight and refund the money

    // Staff like Crew will:
    // The availability wil be provided in a avilabilityMap

    // User like GuestUser will:
    // Search for a flight
    // Register as a user
    // Book a flight which includes multiple passengers
    // Pay via credit card or cash or upi

    public static void main(String[] args) {
        // Airport
        Airport airport1 = new Airport("KRK","Dum Dum Airport");
        Airport airport2 = new Airport("MUM","Mumbai Airport");
        Airport airport3 = new Airport("BAN","Bangalore Airport");
        Airport airport4 = new Airport("HYD","Hyderabad Airport");

        // Aircraft 1
        Map<String,Seat> seats1 = new HashMap<>();
        Map<SeatType, Double> amountMap1 = new HashMap<>();
        amountMap1.put(SeatType.ECONOMY, 5000.0);
        amountMap1.put(SeatType.BUSINESS_CLASS, 12000.0);
        amountMap1.put(SeatType.FIRST_CLASS, 20000.0);

        Aircraft aircraft1 = new Aircraft("A1", seats1, "Boeing 737", amountMap1);

        Seat seat1 = new Seat("E1", aircraft1, SeatType.ECONOMY);
        Seat seat2 = new Seat("B1", aircraft1, SeatType.ECONOMY);
        Seat seat3 = new Seat("F1", aircraft1, SeatType.ECONOMY);
        Seat seat4 = new Seat("G2", aircraft1, SeatType.FIRST_CLASS);
        Seat seat5 = new Seat("H2", aircraft1, SeatType.FIRST_CLASS);
        Seat seat6 = new Seat("K1", aircraft1, SeatType.BUSINESS_CLASS);
        Seat seat7 = new Seat("K2", aircraft1, SeatType.BUSINESS_CLASS);

        // Add seats to aircraft1
        seats1.put(seat1.getId(),seat1);
        seats1.put(seat2.getId(),seat2);
        seats1.put(seat3.getId(),seat3);
        seats1.put(seat4.getId(),seat4);
        seats1.put(seat5.getId(),seat5);
        seats1.put(seat6.getId(),seat6);
        seats1.put(seat7.getId(),seat7);

        // Aircraft 2
        Map<String,Seat> seats2 = new HashMap<>();
        Map<SeatType, Double> amountMap2 = new HashMap<>();
        amountMap2.put(SeatType.ECONOMY, 4500.0);
        amountMap2.put(SeatType.BUSINESS_CLASS, 11000.0);
        amountMap2.put(SeatType.FIRST_CLASS, 18000.0);

        Aircraft aircraft2 = new Aircraft("A2", seats2, "Airbus A320", amountMap2);

        Seat seat8 = new Seat("E1", aircraft2, SeatType.ECONOMY);
        Seat seat9 = new Seat("B1", aircraft2, SeatType.ECONOMY);
        Seat seat10 = new Seat("F1", aircraft2, SeatType.ECONOMY);
        Seat seat11 = new Seat("G2", aircraft2, SeatType.FIRST_CLASS);
        Seat seat12 = new Seat("H2", aircraft2, SeatType.FIRST_CLASS);
        Seat seat13 = new Seat("K1", aircraft2, SeatType.BUSINESS_CLASS);
        Seat seat14 = new Seat("K2", aircraft2, SeatType.BUSINESS_CLASS);

        // Add seats to aircraft2
        seats2.put(seat8.getId(),seat8);
        seats2.put(seat9.getId(),seat9);
        seats2.put(seat10.getId(),seat10);
        seats2.put(seat11.getId(),seat11);
        seats2.put(seat12.getId(),seat12);
        seats2.put(seat13.getId(),seat13);
        seats2.put(seat14.getId(),seat14);

        // Accounts
        Account account1 = new Account("user1@example.com", "pass1");
        Account account2 = new Account("user2@example.com", "pass2");
        Account account3 = new Account("user3@example.com", "pass3");
        Account account4 = new Account("user4@example.com", "pass4");
        Account account5 = new Account("user5@example.com", "pass5");
        Account account6 = new Account("user6@example.com", "pass6");
        Account account7 = new Account("user7@example.com", "pass7");
        Account account8 = new Account("user8@example.com", "pass8");
        Account account9 = new Account("user9@example.com", "pass9");
        Account account10 = new Account("user10@example.com", "pass10");
        Account account11 = new Account("user11@example.com", "pass11");
        Account account12 = new Account("user12@example.com", "pass12");
        Account account13 = new Account("user13@example.com", "pass13");
        Account account14 = new Account("user14@example.com", "pass14");

        // Crews
        Crew crew1 = new Crew("C1", "Alice",account7, airport1);
        Crew crew2 = new Crew("C2", "Bob", account8,airport1);
        Crew crew3 = new Crew("C4", "Emma",account9, airport2);
        Crew crew4 = new Crew("C5", "Charlie",account10, airport3);
        Crew crew5 = new Crew("C6", "Percy",account11, airport3);
        Crew crew6 = new Crew("C7", "John",account12, airport4);
        Crew crew7 = new Crew("C8", "Diana",account13, airport4);

        // Staffs
        Staff staff1 = new Staff("S001", "Alice Smith", account1);
        Staff staff2 = new Staff("S002", "Bob Johnson", account2);
        Staff staff3 = new Staff("S003", "Carol White", account3);

        // Guest Users
        GuestUser guest1 = new GuestUser("G001");
        GuestUser guest2 = new GuestUser("G002");
        GuestUser guest3 = new GuestUser("G003");

        // Registered Users
        RegisteredUser regUser1 = new RegisteredUser("R001", "David Brown", account4);
        RegisteredUser regUser2 = new RegisteredUser("R002", "Emma Davis", account5);
        RegisteredUser regUser3 = new RegisteredUser("R003", "Frank Miller", account6);

        // Admin
        Admin admin = new Admin("A1", "Walter White",account14);

        Notifier notifier = new Notifier(); // basic notifier

        // Create Flight 1
        Flight flight1 = new Flight(
                "FL001",
                airport1,  // Source: Dum Dum Airport
                airport2,  // Destination: Mumbai Airport
                aircraft1,
                Instant.now().plus(Duration.ofHours(2)), // Departure in 2 hours
                Duration.ofHours(3),                     // Flight duration
                notifier,
                6000.0
        );

        // Create Flight 2
        Flight flight2 = new Flight(
                "FL002",
                airport2,
                airport3,
                aircraft2,
                Instant.now().plus(Duration.ofHours(5)),
                Duration.ofHours(2),
                notifier,
                5500.0
        );

        // Create Flight 3
        Flight flight3 = new Flight(
                "FL003",
                airport3,
                airport4,
                aircraft1,
                Instant.now().plus(Duration.ofHours(10)),
                Duration.ofHours(2),
                notifier,
                7000.0
        );

        FlightSearchService flightSearchService = new FlightSearchService(new ArrayList<>(List.of(flight1,flight2,flight3)));

        admin.assignCrewToFlight(flight1);
//        admin.assignCrewToFlight(flight2);
        admin.assignCrewToFlight(flight3);

        // Passengers
        Passenger passenger1 = new Passenger("P001", "Alice", "9876543210", "alice@example.com", 30, 2);
        Passenger passenger2 = new Passenger("P002", "Bob1", "9123456780", "bob1@example.com", 28, 1);
        Passenger passenger3 = new Passenger("P003", "Bob2", "9123456780", "bob2@example.com", 28, 1);
        Passenger passenger4 = new Passenger("P004", "Bob3", "9123456780", "bob3@example.com", 28, 1);

        BookingService bookingService = new BookingService();

        List<Seat> selectedSeats1 = new ArrayList<>(List.of(seat1, seat2));
        Booking booking1 = new Booking("B1",regUser1,flight1,selectedSeats1,List.of(passenger1,passenger2));
        regUser1.bookFlight(bookingService,booking1);
        regUser2.bookFlight(bookingService,booking1);

        Payment payment = booking1.getPayment();
        if(payment!=null) {
            payment.setPaymentStrategy(new CreditCardPayment());
            regUser1.confirm(bookingService,booking1,payment);
        }

        admin.cancelFlight(flight1);
        List<Seat> selectedSeats2 = new ArrayList<>(List.of(seat8, seat13));
        Booking booking2 = new Booking("B2",regUser2,flight2,selectedSeats2,List.of(passenger1,passenger2));
        regUser2.bookFlight(bookingService,booking2);

//      flight2.depart();
        Payment payment1 = booking2.getPayment();
        if(payment1!=null) {
            payment1.setPaymentStrategy(new CashPayment());
            regUser2.confirm(bookingService,booking2,payment1);
        }

        flight2.depart();

        FilterSystem filterSystem1 = new FilterSystem(new ArrayList<>());
        FilterSystem filterSystem2 = new FilterSystem(List.of(Filters.bySource(airport1),Filters.byDestination(airport2)));
        System.out.println(guest1.searchFlights(flightSearchService,filterSystem1));
        System.out.println(guest1.searchFlights(flightSearchService,filterSystem2));
    }
}

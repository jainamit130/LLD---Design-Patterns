package Examples.AirlineManagementSystem;

import Examples.AirlineManagementSystem.entities.aircraft.Aircraft;
import Examples.AirlineManagementSystem.entities.user.Crew;
import Examples.AirlineManagementSystem.entities.flight.Airport;
import Examples.AirlineManagementSystem.entities.aircraft.Seat;
import Examples.AirlineManagementSystem.entities.enums.SeatType;

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
    // Provide there availability in the form of start and end dates with their source Airport and preferred destination Airport
    // The availability wil be provided in a Map<Source Airport, MinHeap<EndDate,CrewId>> avilabilityMap

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
        List<Seat> seats1 = new ArrayList<>();
        Map<SeatType, Double> amountMap1 = new HashMap<>();
        amountMap1.put(SeatType.ECONOMY, 5000.0);
        amountMap1.put(SeatType.BUSINESS_CLASS, 12000.0);
        amountMap1.put(SeatType.FIRST_CLASS, 20000.0);

        Aircraft aircraft1 = new Aircraft("A1", seats1, "Boeing 737", amountMap1);

        // Add seats to aircraft1
        seats1.add(new Seat("E1", aircraft1, SeatType.ECONOMY));
        seats1.add(new Seat("E2", aircraft1, SeatType.ECONOMY));
        seats1.add(new Seat("B1", aircraft1, SeatType.BUSINESS_CLASS));
        seats1.add(new Seat("F1", aircraft1, SeatType.FIRST_CLASS));

        // Aircraft 2
        List<Seat> seats2 = new ArrayList<>();
        Map<SeatType, Double> amountMap2 = new HashMap<>();
        amountMap2.put(SeatType.ECONOMY, 4500.0);
        amountMap2.put(SeatType.BUSINESS_CLASS, 11000.0);
        amountMap2.put(SeatType.FIRST_CLASS, 18000.0);

        Aircraft aircraft2 = new Aircraft("A2", seats2, "Airbus A320", amountMap2);

        seats2.add(new Seat("E3", aircraft2, SeatType.ECONOMY));
        seats2.add(new Seat("E4", aircraft2, SeatType.ECONOMY));
        seats2.add(new Seat("B2", aircraft2, SeatType.BUSINESS_CLASS));
        seats2.add(new Seat("F2", aircraft2, SeatType.FIRST_CLASS));

        // Crews
        Crew crew1 = new Crew("C1", "Alice", airport1);
        Crew crew2 = new Crew("C2", "Bob", airport1);
        Crew crew3 = new Crew("C4", "Emma", airport2);
        Crew crew4 = new Crew("C5", "Charlie", airport3);
        Crew crew5 = new Crew("C6", "Percy", airport3);
        Crew crew6 = new Crew("C7", "John", airport4);
        Crew crew7 = new Crew("C8", "Diana", airport4);


    }
}

package Examples.AirlineManagementSystem.entities.aircraft;

import Examples.AirlineManagementSystem.entities.enums.SeatType;

import java.util.List;
import java.util.Map;

public class Aircraft {
    private final String aircraftId;
    private final List<Seat> seats;
    private final String airCraftType;
    private Map<SeatType,Double> amountMap; // aircraft amount varies with the type of aircraft independent of flight

    public Aircraft(String aircraftId, List<Seat> seats, String airCraftType, Map<SeatType, Double> amountMap) {
        this.aircraftId = aircraftId;
        this.seats = seats;
        this.airCraftType = airCraftType;
        this.amountMap = amountMap;
    }

    public double getSeatPrice(Seat seat) {
        return amountMap.get(seat.getSeatType());
    }
}

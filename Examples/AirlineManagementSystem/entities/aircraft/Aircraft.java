package Examples.AirlineManagementSystem.entities.aircraft;

import Examples.AirlineManagementSystem.entities.enums.SeatType;

import java.util.Map;

public class Aircraft {
    private final String aircraftId;
    private final Map<String,Seat> seatMap;
    private final String airCraftType;
    private Map<SeatType,Double> amountMap; // aircraft amount varies with the type of aircraft independent of flight

    public Aircraft(String aircraftId, Map<String,Seat> seatMap, String airCraftType, Map<SeatType, Double> amountMap) {
        this.aircraftId = aircraftId;
        this.seatMap = seatMap;
        this.airCraftType = airCraftType;
        this.amountMap = amountMap;
    }

    public Seat getSeat(String seatId) { return seatMap.get(seatId); }

    public double getSeatPrice(Seat seat) {
        return amountMap.get(seat.getSeatType());
    }
}

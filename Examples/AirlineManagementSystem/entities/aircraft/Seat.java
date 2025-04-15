package Examples.AirlineManagementSystem.entities.aircraft;

import Examples.AirlineManagementSystem.entities.enums.SeatType;
import Examples.AirlineManagementSystem.entities.enums.SeatStatus;

public class Seat {
    private final String seatId;
    private final Aircraft aircraft;
    private final SeatType seatType;
    private SeatStatus seatStatus;

    public Seat(String seatId, Aircraft aircraft, SeatType seatType) {
        this.seatId = seatId;
        this.aircraft = aircraft;
        this.seatType = seatType;
        this.seatStatus = SeatStatus.VACANT;

    }

    public double getPrice() {
        return aircraft.getSeatPrice(this);
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public boolean isVacant() {
        return seatStatus.equals(SeatStatus.VACANT);
    }

    public void reserveSeat() { seatStatus = SeatStatus.RESERVED; }
}

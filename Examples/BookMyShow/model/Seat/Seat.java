package Examples.BookMyShow.model.Seat;

import Examples.BookMyShow.model.Venue;

import java.math.BigDecimal;

public class Seat {
    private String seatId;
    private SeatState state;
    private Venue venue;
    private BigDecimal amount;

    public Seat(String seatId, Venue venue, BigDecimal amount) {
        this.seatId = seatId;
        this.venue = venue;
        this.amount = amount;
        this.state = new Vacant(this);
    }

    public String getSeatId() {
        return seatId;
    }

    public void setState(SeatState state) {
        this.state = state;
    }

    public boolean validate() {
        return venue.validate(this);
    }

    public boolean book() {
        return state.book();
    }

    public boolean reserve() {
        if(state.reserve()) return true;
        return false;
    }

    public boolean cancel() {
        return state.cancel();
    }

    public boolean expire() {
        return state.expire();
    }
}

package Examples.BookMyShow.model;

import Examples.BookMyShow.model.Seat.Seat;

import java.util.ArrayList;
import java.util.List;

public class Venue {
    private String venueId;
    private final String address;
    private final List<Showing> showings;
    private final List<Seat> seats;

    public Venue(String address, String venueId) {
        this.seats = new ArrayList<>();
        this.showings = new ArrayList<>();
        this.address = address;
        this.venueId = venueId;
    }

    public void addShowing(Showing showing) {
        showings.add(showing);
    }

    public boolean validate(Seat seat) {
        return seats.contains(seat);
    }

    public boolean validate(Showing showing) {
        return showings.contains(showing);
    }
}

/*
Venue will have seats which is either filled or empty
Venue will trigger the reservation and booking of seat thus triggering seat to change its state
*/

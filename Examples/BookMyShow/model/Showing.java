package Examples.BookMyShow.model;

import java.time.Instant;

public class Showing {
    private String showingId;
    private Instant start;
    private Instant end;
    private Event event;
    private Venue venue;

    public Showing(String showingId, Instant start, Instant end, Event event, Venue venue) {
        this.showingId = showingId;
        this.start = start;
        this.end = end;
        this.event = event;
        this.venue = venue;
    }

    public boolean validate() {
        return event.validate(venue) && venue.validate(this) && event.validate(this);
    }
}

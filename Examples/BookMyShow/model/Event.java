package Examples.BookMyShow.model;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String eventId;
    private String eventName;
    private List<Venue> venues;
    private final List<Showing> showings;

    public Event(String eventId, String eventName) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.showings = new ArrayList<>();
        this.venues = new ArrayList<>();
    }

    public boolean validate(Venue venue) {
        return venues.contains(venue);
    }

    public boolean validate(Showing showing) {
        return showings.contains(showing);
    }

    public void addVenue(Venue venue) {
        venues.add(venue);
    }
}

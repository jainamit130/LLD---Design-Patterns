package Examples.BookMyShow.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Event {
    private String eventId;
    private String eventName;
    private Venue venue;
    private Map<LocalDate, List<Showing>> showingsMap;

}

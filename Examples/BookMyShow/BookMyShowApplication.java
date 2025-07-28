package Examples.BookMyShow;

import Examples.BookMyShow.model.Booking.Booking;
import Examples.BookMyShow.model.Event;
import Examples.BookMyShow.model.Reservation.Reservation;
import Examples.BookMyShow.model.Seat.Seat;
import Examples.BookMyShow.model.Showing;
import Examples.BookMyShow.model.User;
import Examples.BookMyShow.model.Venue;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class BookMyShowApplication {

    public static void main(String[] args) {
        User user = new User("1","Alice");
        Event cricketMatch = new Event("1","India Vs Australia");
        Venue stadium = new Venue("1","Wankhade Stadium");
        cricketMatch.addVenue(stadium);

        Instant start = Instant.now().plus(2, ChronoUnit.HOURS);
        Instant end = start.plus(4, ChronoUnit.HOURS);

        Showing showing = new Showing("showing-1", start, end, cricketMatch, stadium);
        Seat seat1 = new Seat("A1", stadium, new BigDecimal(200));
        Seat seat2 = new Seat("A2", stadium, new BigDecimal(200));
        List<Seat> seats = Arrays.asList(seat1, seat2);
        Reservation reservation = new Reservation("reservation1",seats);
        stadium.addShowing(showing);
        Reservation reserved = user.reserve(reservation);
    }
}

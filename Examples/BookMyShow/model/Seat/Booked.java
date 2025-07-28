package Examples.BookMyShow.model.Seat;

public class Booked extends SeatState {

    protected Booked(Seat seat) {
        super(SeatStatus.BOOKED, seat);
    }

    @Override
    public boolean reserve() {
        System.out.println("Already booked!");
        return false;
    }

    @Override
    public boolean book() {
        System.out.println("Already booked!");
        return false;
    }

    @Override
    public boolean cancel() {
        seat.setState(new Vacant(seat));
        return true;
    }

    @Override
    public boolean expire() {
        System.out.println("Already booked. Hence cannot expire!");
        return false;
    }
}

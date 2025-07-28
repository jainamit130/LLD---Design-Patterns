package Examples.BookMyShow.model.Seat;

public class Reserved extends SeatState {

    protected Reserved(Seat seat) {
        super(SeatStatus.RESERVED, seat);
    }

    @Override
    public boolean reserve() {
        System.out.println("Already reserved!");
        return false;
    }

    @Override
    public boolean book() {
        seat.setState(new Booked(seat));
        return true;
    }

    @Override
    public boolean cancel() {
        seat.setState(new Vacant(seat));
        return true;
    }

    @Override
    public boolean expire() {
        seat.setState(new Vacant(seat));
        return true;
    }
}

package Examples.BookMyShow.model.Seat;

public class Vacant extends SeatState {

    protected Vacant(Seat seat) {
        super(SeatStatus.VACANT, seat);
    }

    @Override
    public boolean reserve() {
        seat.setState(new Reserved(seat));
        return true;
    }

    @Override
    public boolean book() {
        System.out.println("Reservation expired! Reserve again!");
        return false;
    }

    @Override
    public boolean cancel() {
        System.out.println("First try booking!");
        return true;
    }

    @Override
    public boolean expire() {
        System.out.println("First reserve!");
        return false;
    }


}

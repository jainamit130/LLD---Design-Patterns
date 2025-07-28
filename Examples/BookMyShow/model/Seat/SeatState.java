package Examples.BookMyShow.model.Seat;

public abstract class SeatState {
    protected final SeatStatus status;
    protected final Seat seat;

    protected SeatState(SeatStatus status, Seat seat) {
        this.status = status;
        this.seat = seat;
    }

    public abstract boolean reserve();
    public abstract boolean book();
    public abstract boolean cancel();
    public abstract boolean expire();
}


/*
Reserved
Vacant
Booked
*/

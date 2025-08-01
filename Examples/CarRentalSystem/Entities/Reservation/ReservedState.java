package Examples.CarRentalSystem.Entities.Reservation;

import Examples.CarRentalSystem.Entities.Status;

public class ReservedState extends ReservationState {

    public ReservedState(Reservation reservation) {
        super(reservation, Status.RESERVED);
    }

    @Override
    public String getNotificationMessage() {
        return "Reserved "+ reservation.getReservationId() + " is reserved";
    }

    @Override
    public void reserve() {
        System.out.println(getErrorMessage(Status.RESERVED));
    }

    @Override
    public void cancel() {
        reservation.setState(new CancelledState(reservation));
    }

    @Override
    public void activate() {
        reservation.setState(new ActiveState(reservation));
    }

    @Override
    public void complete() {
        System.out.println(getErrorMessage(Status.RESERVED));
    }
}

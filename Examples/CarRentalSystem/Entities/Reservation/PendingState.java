package Examples.CarRentalSystem.Entities.Reservation;

import Examples.CarRentalSystem.Entities.Status;

public class PendingState extends ReservationState {

    public PendingState(Reservation reservation) {
        super(reservation, Status.PENDING);
    }

    @Override
    public String getNotificationMessage() {
        return "Reservation "+ reservation.getReservationId() + " is pending";
    }

    @Override
    public void reserve() {
        reservation.setState(new ReservedState(reservation));
    }

    @Override
    public void confirm() {
        System.out.println(getErrorMessage(Status.PENDING));
    }

    @Override
    public void cancel() {
        reservation.setState(new CancelledState(reservation));
    }

    @Override
    public void activate() {
        System.out.println(getErrorMessage(Status.PENDING));
    }

    @Override
    public void complete() {
        System.out.println(getErrorMessage(Status.PENDING));
    }
}

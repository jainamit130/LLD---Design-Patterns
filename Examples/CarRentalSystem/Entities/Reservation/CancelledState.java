package Examples.CarRentalSystem.Entities.Reservation;

import Examples.CarRentalSystem.Entities.Status;

public class CancelledState extends ReservationState {

    public CancelledState(Reservation reservation) {
        super(reservation, Status.CANCELLED);
    }

    @Override
    public String getNotificationMessage() {
        return "Reservation "+ reservation.getReservationId() + " is cancelled";
    }

    @Override
    public void reserve() {
        System.out.println(getErrorMessage(Status.CANCELLED));
    }

    @Override
    public void cancel() {
        System.out.println(getErrorMessage(Status.CANCELLED));
    }

    @Override
    public void activate() {
        System.out.println(getErrorMessage(Status.CANCELLED));
    }

    @Override
    public void complete() {
        System.out.println(getErrorMessage(Status.CANCELLED));
    }
}

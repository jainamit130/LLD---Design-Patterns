package Examples.CarRentalSystem.Entities.Reservation;

import Examples.CarRentalSystem.Entities.Status;

public class ActiveState extends ReservationState {

    public ActiveState(Reservation reservation) {
        super(reservation, Status.ACTIVE);
    }

    @Override
    public String getNotificationMessage() {
        return "Reservation "+ reservation.getReservationId() + " is activated";
    }

    @Override
    public void reserve() {
        System.out.println(getErrorMessage(Status.RESERVED));
    }

    @Override
    public void confirm() {
        System.out.println(getErrorMessage(Status.ACTIVE));
    }

    @Override
    public void cancel() {
        System.out.println(getErrorMessage(Status.ACTIVE));
    }

    @Override
    public void activate() {
        System.out.println(getErrorMessage(Status.ACTIVE));
    }

    @Override
    public void complete() {
        reservation.setState(new CompleteState(reservation));
    }
}

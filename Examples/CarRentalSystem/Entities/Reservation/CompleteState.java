package Examples.CarRentalSystem.Entities.Reservation;

import Examples.CarRentalSystem.Entities.Status;

public class CompleteState extends ReservationState {

    public CompleteState(Reservation reservation) {
        super(reservation, Status.COMPLETED);
    }

    @Override
    public String getNotificationMessage() {
        return "Reservation "+ reservation.getReservationId() + " is completed";
    }

    @Override
    public void reserve() {
        System.out.println(getErrorMessage(Status.COMPLETED));
    }

    @Override
    public void confirm() {
        System.out.println(getErrorMessage(Status.COMPLETED));
    }

    @Override
    public void cancel() {
        System.out.println(getErrorMessage(Status.COMPLETED));
    }

    @Override
    public void activate() {
        System.out.println(getErrorMessage(Status.COMPLETED));
    }

    @Override
    public void complete() {
        System.out.println(getErrorMessage(Status.COMPLETED));
    }
}

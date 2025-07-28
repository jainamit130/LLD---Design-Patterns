package Examples.CarRentalSystem.Entities.Reservation;

import Examples.CarRentalSystem.Entities.Status;

public abstract class ReservationState {
    protected final Reservation reservation;
    private final Status status;
    public ReservationState(Reservation reservation, Status status) {
        this.reservation = reservation;
        this.status = status;
    }

    protected String getErrorMessage(Status newStatus) {
        return "Reserved state is "+status.name()+" and cannot be " + newStatus.toString() + "!";
    }

    public abstract String getNotificationMessage();
    public abstract void reserve();
    public abstract void cancel();
    public abstract void activate();
    public abstract void complete();

    @Override
    public String toString() {
        return "ReservationState{" +
                "status=" + status +
                '}';
    }
}

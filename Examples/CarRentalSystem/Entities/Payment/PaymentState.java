package Examples.CarRentalSystem.Entities.Payment;

public abstract class PaymentState {
    protected final Payment payment;
    protected PaymentStatus status;

    protected PaymentState(Payment payment, PaymentStatus status) {
        this.payment = payment;
        this.status = status;
    }

    protected String getErrorMessage(PaymentStatus newStatus) {
        return "Payment state is " + newStatus.toString() +" and cannot be " + newStatus.toString() + "!";
    }

    protected abstract boolean pay();
    protected abstract boolean cancel();
    protected abstract boolean refund();

}

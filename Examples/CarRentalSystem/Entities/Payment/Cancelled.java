package Examples.CarRentalSystem.Entities.Payment;

public class Cancelled extends PaymentState{
    public Cancelled(Payment payment) {
        super(payment, PaymentStatus.CANCELLED);
    }

    @Override
    protected boolean pay() {
        System.out.println(getErrorMessage(PaymentStatus.PAID));
        return false;
    }

    @Override
    protected boolean cancel() {
        System.out.println(getErrorMessage(PaymentStatus.CANCELLED));
        return false;
    }

    @Override
    protected boolean refund() {
        System.out.println(getErrorMessage(PaymentStatus.REFUNDED));
        return false;
    }
}

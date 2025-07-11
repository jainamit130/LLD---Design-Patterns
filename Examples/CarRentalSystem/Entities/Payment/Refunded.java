package Examples.CarRentalSystem.Entities.Payment;

public class Refunded extends PaymentState{
    public Refunded(Payment payment) {
        super(payment, PaymentStatus.REFUNDED);
    }

    @Override
    protected boolean pay() {
        boolean isSuccess = payment.paying();
        if(isSuccess) payment.setState(new Paid(payment));
        return isSuccess;
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

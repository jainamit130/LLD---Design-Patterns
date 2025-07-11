package Examples.CarRentalSystem.Entities.Payment;

public class Failed extends PaymentState{
    public Failed(Payment payment) {
        super(payment, PaymentStatus.FAILED);
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

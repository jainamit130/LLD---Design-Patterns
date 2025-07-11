package Examples.CarRentalSystem.Entities.Payment;

public class Due extends PaymentState{
    public Due(Payment payment) {
        super(payment, PaymentStatus.DUE);
    }

    @Override
    protected boolean pay() {
        boolean isSuccess = payment.paying();
        if(isSuccess) payment.setState(new Paid(payment));
        return isSuccess;
    }

    @Override
    protected boolean cancel() {
        boolean isSuccess = payment.cancelling();
        if(isSuccess) payment.setState(new Cancelled(payment));
        return true;
    }

    @Override
    protected boolean refund() {
        // additional logic for payment breakdowns and refunds can be integrated
        System.out.println(getErrorMessage(PaymentStatus.REFUNDED));
        return false;
    }
}

package Examples.CarRentalSystem.Entities.Payment;

public class Paid extends PaymentState{
    public Paid(Payment payment) {
        super(payment, PaymentStatus.PAID);
    }

    @Override
    protected boolean pay() {
        System.out.println(getErrorMessage(PaymentStatus.PAID));
        return false;
    }

    @Override
    protected boolean cancel() {
        return true;
    }

    @Override
    protected boolean refund() {
        boolean isSuccess = payment.refunding();
        if(isSuccess) payment.setState(new Refunded(payment));
        return isSuccess;
    }
}

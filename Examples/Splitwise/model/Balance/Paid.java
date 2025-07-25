package Examples.Splitwise.model.Balance;

import Examples.Splitwise.model.User;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class Paid extends Balance {

    public Paid(User user, AtomicReference<BigDecimal> amount) {
        super(user,amount);
    }

    @Override
    public BigDecimal getSignedAmount() {
        return amount.get();
    }
}

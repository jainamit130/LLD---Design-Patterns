package Examples.Splitwise.model.Balance;

import Examples.Splitwise.model.User;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class Owe extends Balance {
    public Owe(User user) {
        super(user);
    }

    public Owe(User user, AtomicReference<BigDecimal> amount) {
        super(user, amount);
    }

    @Override
    public BigDecimal getSignedAmount() {
        return amount.get();
    }
}

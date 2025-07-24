package Examples.Splitwise.model.Balance;

import Examples.Splitwise.model.User;

import java.math.BigDecimal;

public class Paid extends Balance {

    public Paid(User user) {
        super(user);
    }

    @Override
    public BigDecimal getSignedAmount() {
        return amount.get();
    }
}

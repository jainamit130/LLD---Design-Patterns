package Examples.Splitwise.model.Balance;

import Examples.Splitwise.model.User;

import java.math.BigDecimal;

public class Borrowed extends Balance {

    public Borrowed(User user) {
        super(user);
    }

    @Override
    public BigDecimal getSignedAmount() {
        return amount.get().negate();
    }
}

package Examples.Splitwise.model.Balance;

import Examples.Splitwise.model.User;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class BalanceFactory {

    public static Balance getBalance(AtomicReference<BigDecimal> amount, User user) {
        if(amount.get().compareTo(BigDecimal.ZERO)==1) return new Owe(user,amount);
        return new Borrow(user,amount);
    }

    public static Balance getReceiverBalance(User user,Balance balance) {
        return getBalance(new AtomicReference<>(balance.getSignedAmount()),user);
    }
}

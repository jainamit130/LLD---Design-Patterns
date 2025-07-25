package Examples.Splitwise.model.Balance;

import Examples.Splitwise.model.User;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class BalanceFactory {

    public static Balance getBalance(BigDecimal amount, User user) {
        if(amount.compareTo(BigDecimal.ZERO)==1) return new Owe(user,new AtomicReference<>(amount.abs()));
        return new Borrow(user,new AtomicReference<>(amount.abs()));
    }

    public static Balance getReceiverBalance(User user,Balance balance) {
        return getBalance(balance.getAmount().get(),user);
    }
}

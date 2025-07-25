package Examples.Splitwise.model.Balance;

import Examples.Splitwise.model.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Balance {
    protected User user;
    protected final AtomicReference<BigDecimal> amount;

    public Balance(User user) {
        this.user = user;
        this.amount = new AtomicReference<>(BigDecimal.ZERO);
    }

    public Balance(User user, AtomicReference<BigDecimal> amount) {
        this.user = user;
        this.amount = amount;
    }

    public AtomicReference<BigDecimal> getAmount() {
        return amount;
    }

    public abstract BigDecimal getSignedAmount();

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object transaction) {
        if(this == transaction) return true;
        if(!(transaction instanceof Balance)) return false;
        return user.equals(((Balance) transaction).getUser());
    }

    public Balance add(Balance balance) {
        return  BalanceFactory.getBalance(this.getSignedAmount().add(balance.getSignedAmount()),user);
    }

    public Balance minus(Balance balance) {
        return  BalanceFactory.getBalance(this.getSignedAmount().subtract(balance.getSignedAmount()),user);
    }

    public static BigDecimal addAll(List<? extends Balance> transactions) {
        return transactions.stream().map(Balance::getSignedAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    public static boolean areAllUnique(List<? extends Balance> transactions) {
        long distinctCount = transactions.stream().distinct().count();
        return distinctCount == transactions.size();
    }

}

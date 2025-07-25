package Examples.Splitwise.model.Balance;

import Examples.Splitwise.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BalanceSheet {
    private final Map<User, Balance> balances;

    public BalanceSheet() {
        this.balances = new ConcurrentHashMap();
    }

    public void minusBalance(Balance balance) {
        balances.put(balance.getUser(),balances.getOrDefault(balance.getUser(),new Owe(balance.getUser())).minus(balance));
    }

    public void addBalance(Balance balance) {
        balances.put(balance.getUser(),balances.getOrDefault(balance.getUser(),new Owe(balance.getUser())).add(balance));
    }

    public void setBalance(Balance balance) {
        balances.put(balance.getUser(),balance);
    }

    public Balance getBalance(User user) {
        return balances.getOrDefault(user,new Owe(user));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BalanceSheet:\n");
        for (Map.Entry<User, Balance> entry : balances.entrySet()) {
            sb.append(" - ")
                    .append(entry.getKey().getName())
                    .append(": ")
                    .append(entry.getValue().getSignedAmount())
                    .append("\n");
        }
        return sb.toString();
    }

}

package Examples.Splitwise.model;

import Examples.Splitwise.model.Expense.Expense;

import java.math.BigDecimal;

public class Split {
    private String splitId;
    private Expense expense;
    private User user;
    private BigDecimal amount;
    private SplitType type;

    public Split(Expense expense, User user, BigDecimal amount, SplitType type) {
        this.expense = expense;
        this.user = user;
        this.amount = amount;
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

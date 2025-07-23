package Examples.Splitwise.model.Expense;

import Examples.Splitwise.model.Split;
import Examples.Splitwise.model.SplitAlgorithm;
import Examples.Splitwise.model.Transaction.Owed;
import Examples.Splitwise.model.User;

import java.math.BigDecimal;
import java.util.List;

public abstract class Expense {
    private String expenseId;
    private List<Split> splits;
    private User createdBy;
    private SplitAlgorithm splitAlgorithm;
    private BigDecimal amount;
    private List<Owed> payers;

    public abstract boolean validate();

    public Expense(PartialExpense partialExpense) {
        this.createdBy = partialExpense.getCreatedBy();
        this.splitAlgorithm = partialExpense.getSplitAlgorithm();
        this.amount = partialExpense.getAmount();
        this.payers = partialExpense.getPayers();
    }
}

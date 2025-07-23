package Examples.Splitwise.model.Expense;

import Examples.Splitwise.model.SplitAlgorithm;
import Examples.Splitwise.model.Transaction.Owed;
import Examples.Splitwise.model.User;

import java.math.BigDecimal;
import java.util.List;

public class PartialExpense {
    private SplitAlgorithm splitAlgorithm;
    private BigDecimal amount;
    private List<Owed> payers;
    private User createdBy;

    public SplitAlgorithm getSplitAlgorithm() {
        return splitAlgorithm;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public List<Owed> getPayers() {
        return payers;
    }

    public User getCreatedBy() {
        return createdBy;
    }
}

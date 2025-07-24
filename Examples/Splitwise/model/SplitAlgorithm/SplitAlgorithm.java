package Examples.Splitwise.model.SplitAlgorithm;

import Examples.Splitwise.model.Expense.Expense;
import Examples.Splitwise.model.Split;
import Examples.Splitwise.model.SplitType;

import java.util.List;

public abstract class SplitAlgorithm {
    protected Expense expense;

    protected SplitAlgorithm() {
    }

    public abstract boolean validate();
    public abstract SplitType getSplitType();
    public abstract List<Split> getValidSplits();

    public void setExpense(Expense expense) {
        this.expense = expense;
    }
}

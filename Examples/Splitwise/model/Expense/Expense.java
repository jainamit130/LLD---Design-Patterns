package Examples.Splitwise.model.Expense;

import Examples.Splitwise.ExceptionHandling.InvalidExpenseException;
import Examples.Splitwise.model.Balance.BalanceSheet;
import Examples.Splitwise.model.Expense.ExpenseRequestDTO.ExpenseDTO;
import Examples.Splitwise.model.Split;
import Examples.Splitwise.model.SplitAlgorithm.SplitAlgorithm;
import Examples.Splitwise.model.Balance.Paid;
import Examples.Splitwise.model.User;

import java.math.BigDecimal;
import java.util.List;

public abstract class Expense {
    private String expenseId;
    private String expenseName;
    private String expenseDescription;
    private List<Split> splits;
    private User createdBy;
    private SplitAlgorithm splitAlgorithm;
    private BigDecimal amount;
    private List<Paid> participants;
    private BalanceSheet balanceSheet;

    public Expense(ExpenseDTO expenseDTO) throws InvalidExpenseException {
        if(ExpenseValidator.validate(expenseDTO)) throw new InvalidExpenseException();
        this.createdBy = expenseDTO.getCreatedBy();
        this.splitAlgorithm = expenseDTO.getSplitAlgorithm();
        this.splitAlgorithm.setExpense(this);
        this.amount = expenseDTO.getAmount();
        this.participants = expenseDTO.getParticipants();
    }

    public SplitAlgorithm getSplitAlgorithm() {
        return splitAlgorithm;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public List<Paid> getParticipants() {
        return participants;
    }

    @Override
    public String toString() {
        return "Expense{amount=" + amount + ", createdBy=" + createdBy + ", participants=" + participants + "}";
    }

    public void populateValidSplits() {
        splits = getSplitAlgorithm().getValidSplits();
    }
}

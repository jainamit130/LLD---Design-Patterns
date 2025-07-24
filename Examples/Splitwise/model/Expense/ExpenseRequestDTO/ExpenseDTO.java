package Examples.Splitwise.model.Expense.ExpenseRequestDTO;

import Examples.Splitwise.model.SplitAlgorithm.SplitAlgorithm;
import Examples.Splitwise.model.Balance.Paid;
import Examples.Splitwise.model.User;

import java.math.BigDecimal;
import java.util.List;

public abstract class ExpenseDTO {
    private String expenseName;
    protected String description;
    protected SplitAlgorithm splitAlgorithm;
    protected BigDecimal amount;
    protected List<Paid> participants;
    protected User createdBy;

    public abstract boolean validate();

    public String getExpenseName() {
        return expenseName;
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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public void setSplitAlgorithm(SplitAlgorithm splitAlgorithm) {
        this.splitAlgorithm = splitAlgorithm;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setParticipants(List<Paid> participants) {
        this.participants = participants;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}

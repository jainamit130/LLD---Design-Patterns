package Examples.Splitwise.model.Expense.ExpenseRequestDTO;

import Examples.Splitwise.model.Balance.Paid;
import Examples.Splitwise.model.SplitAlgorithm.SplitAlgorithm;
import Examples.Splitwise.model.User;

import java.math.BigDecimal;
import java.util.List;

public class DirectExpenseDTO extends ExpenseDTO {

    public DirectExpenseDTO(String expenseName, String description, SplitAlgorithm splitAlgorithm, BigDecimal amount, List<Paid> participants, User createdBy) {
        super(expenseName, description, splitAlgorithm, amount, participants, createdBy);
    }

    @Override
    public boolean validate() {
        return participants.size()==2;
    }
}

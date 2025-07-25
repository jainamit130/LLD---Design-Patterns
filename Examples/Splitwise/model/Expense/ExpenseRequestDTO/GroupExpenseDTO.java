package Examples.Splitwise.model.Expense.ExpenseRequestDTO;

import Examples.Splitwise.model.Balance.Balance;
import Examples.Splitwise.model.Balance.Paid;
import Examples.Splitwise.model.Group;
import Examples.Splitwise.model.SplitAlgorithm.SplitAlgorithm;
import Examples.Splitwise.model.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class GroupExpenseDTO extends ExpenseDTO {
    private Group group;

    public GroupExpenseDTO(String expenseName, String description, SplitAlgorithm splitAlgorithm, BigDecimal amount, List<Paid> participants, User createdBy, Group group) {
        super(expenseName, description, splitAlgorithm, amount, participants, createdBy);
        this.group = group;
    }

    @Override
    public boolean validate() {
        return participants.size()>1 && group.areAllPartOfGroup(participants.stream().map(Balance::getUser).collect(Collectors.toUnmodifiableList()));
    }
}

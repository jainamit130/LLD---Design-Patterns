package Examples.Splitwise.model.Expense.ExpenseRequestDTO;

import Examples.Splitwise.model.Balance.Balance;
import Examples.Splitwise.model.Group;

import java.util.stream.Collectors;

public class GroupExpenseDTO extends ExpenseDTO {
    private Group group;

    public GroupExpenseDTO(Group group) {
        this.group = group;
    }

    @Override
    public boolean validate() {
        return participants.size()>1 && group.areAllPartOfGroup(participants.stream().map(Balance::getUser).collect(Collectors.toUnmodifiableList()));
    }
}

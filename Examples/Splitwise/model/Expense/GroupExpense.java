package Examples.Splitwise.model.Expense;

import Examples.Splitwise.model.Group;

public class GroupExpense extends Expense {
    private Group group;

    public GroupExpense(Group group, PartialExpense expense) {
        super(expense);
        this.group = group;
    }

    @Override
    public boolean validate() {
        // only 2 splits with right users

    }
}

package Examples.Splitwise.model.Expense;

import Examples.Splitwise.ExceptionHandling.InvalidExpenseException;
import Examples.Splitwise.model.Expense.ExpenseRequestDTO.ExpenseDTO;
import Examples.Splitwise.model.Group;

public class GroupExpense extends Expense {
    private Group group;

    public GroupExpense(Group group, ExpenseDTO expense) throws InvalidExpenseException {
        super(expense);
        this.group = group;
    }

}

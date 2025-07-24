package Examples.Splitwise.model.Expense;

import Examples.Splitwise.ExceptionHandling.InvalidExpenseException;
import Examples.Splitwise.model.Expense.ExpenseRequestDTO.ExpenseDTO;
import Examples.Splitwise.model.User;

public class DirectExpense extends Expense {
    private User user1;
    private User user2;

    public DirectExpense(ExpenseDTO expenseDTO) throws InvalidExpenseException {
        super(expenseDTO);
    }
}

/*

Cases

Case1 => Both users paid some amount
Case2 => 1 user paid in full




* */

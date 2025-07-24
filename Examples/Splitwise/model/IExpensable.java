package Examples.Splitwise.model;

import Examples.Splitwise.ExceptionHandling.InvalidExpenseException;
import Examples.Splitwise.model.Expense.Expense;
import Examples.Splitwise.model.Expense.ExpenseRequestDTO.ExpenseDTO;

public interface IExpensable {
    Expense createExpense(ExpenseDTO expense) throws InvalidExpenseException;
}

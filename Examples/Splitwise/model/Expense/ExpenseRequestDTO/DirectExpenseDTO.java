package Examples.Splitwise.model.Expense.ExpenseRequestDTO;

public class DirectExpenseDTO extends ExpenseDTO {

    @Override
    public boolean validate() {
        return participants.size()==2;
    }
}

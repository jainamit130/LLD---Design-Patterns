package Examples.Splitwise.model.Expense;

import Examples.Splitwise.model.User;

public class DirectExpense extends Expense {
    private User user1;
    private User user2;

    @Override
    public boolean validate() {
        return false;
    }
}

/*

Cases

Case1 => Both users paid some amount
Case2 => 1 user paid in full




* */

package Examples.Splitwise.model;

import Examples.Splitwise.model.Expense.Expense;
import Examples.Splitwise.model.Expense.PartialExpense;

import java.util.List;

public class User {
    private String userId;
    private String name;
    private List<Group> groups;
    private BalanceSheet balanceSheet;

    public Group createGroup(List<User> users, String groupId, String groupName, String description) {
        return new Group(groupId,groupName,description,users);
    }

    public Expense createExpense(Group group, PartialExpense expense) {
        return group.createExpense(expense);
    }

    public Expense createExpense(User user) {

    }
}

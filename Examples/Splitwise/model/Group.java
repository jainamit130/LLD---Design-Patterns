package Examples.Splitwise.model;

import Examples.Splitwise.model.Expense.Expense;
import Examples.Splitwise.model.Expense.GroupExpense;
import Examples.Splitwise.model.Expense.PartialExpense;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupId;
    private String groupName;
    private String groupDesc;
    private List<User> users;
    private final List<Expense> expenses;

    public Group(String groupId, String groupName, String groupDesc, List<User> users) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDesc = groupDesc;
        this.users = users;
        this.expenses = new ArrayList<>();
    }

    public Expense createExpense(PartialExpense expense) {
        return new GroupExpense(this,expense);
    }
}

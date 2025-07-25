package Examples.Splitwise.model;

import Examples.Splitwise.ExceptionHandling.InvalidExpenseException;
import Examples.Splitwise.model.Expense.Expense;
import Examples.Splitwise.model.Expense.GroupExpense;
import Examples.Splitwise.model.Expense.ExpenseRequestDTO.ExpenseDTO;

import java.util.ArrayList;
import java.util.List;

public class Group implements IExpensable {
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

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public boolean areAllPartOfGroup(List<User> users) {
        return this.users.containsAll(users);
    }

    @Override
    public Expense createExpense(ExpenseDTO expense) throws InvalidExpenseException {
        return new GroupExpense(this,expense);
    }

    @Override
    public String toString() {
        return "Group{id='" + groupId + "', name='" + groupName + "', members=" + users + "}";
    }
}

package Examples.Splitwise.model;

import Examples.Splitwise.ExceptionHandling.InvalidExpenseException;
import Examples.Splitwise.model.Balance.Balance;
import Examples.Splitwise.model.Balance.BalanceFactory;
import Examples.Splitwise.model.Balance.BalanceSheet;
import Examples.Splitwise.model.Expense.DirectExpense;
import Examples.Splitwise.model.Expense.Expense;
import Examples.Splitwise.model.Expense.ExpenseRequestDTO.ExpenseDTO;

import java.util.ArrayList;
import java.util.List;

public class User implements IExpensable {
    private String userId;
    private String name;
    private List<Group> groups;
    private final List<Expense> expenses;
    private BalanceSheet balanceSheet;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.groups = new ArrayList<>();
        this.expenses = new ArrayList<>();
        this.balanceSheet = new BalanceSheet();
    }

    public String getName() {
        return name;
    }

    private Balance getReceiverBalance(Balance balance) {
        return BalanceFactory.getReceiverBalance(this,balance);
    }

    public boolean isValidExpense(Expense expense) {
        return expenses.contains(expense);
    }

    public Group createGroup(List<User> users, String groupId, String groupName, String description) {
        return new Group(groupId,groupName,description,users);
    }

    public BalanceSheet receiveSettlement(Balance balance) {
        balanceSheet.minusBalance(balance);
        return balanceSheet;
    }

    public BalanceSheet settleBalance(Balance balance) {
        balanceSheet.addBalance(balance);
        balance.getUser().getReceiverBalance(getReceiverBalance(balance));
        return balanceSheet;
    }

    public Expense createExpense(IExpensable entity, ExpenseDTO expenseDto) throws InvalidExpenseException {
        Expense expense = entity.createExpense(expenseDto);
        expense.populateValidSplits();
        expenses.add(expense);
        return expense;
    }

    @Override
    public Expense createExpense(ExpenseDTO expense) throws InvalidExpenseException {
        return new DirectExpense(expense);
    }

    @Override
    public String toString() {
        return "User{id='" + userId + "', name='" + name + "'}";
    }

    public String printBalanceSheet() {
        return balanceSheet.toString();
    }
}

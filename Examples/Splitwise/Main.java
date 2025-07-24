package Examples.Splitwise;

import Examples.Splitwise.ExceptionHandling.InvalidExpenseException;
import Examples.Splitwise.model.Balance.Paid;
import Examples.Splitwise.model.Expense.Expense;
import Examples.Splitwise.model.Expense.ExpenseRequestDTO.DirectExpenseDTO;
import Examples.Splitwise.model.Expense.ExpenseRequestDTO.ExpenseDTO;
import Examples.Splitwise.model.Expense.ExpenseRequestDTO.GroupExpenseDTO;
import Examples.Splitwise.model.Group;
import Examples.Splitwise.model.SplitAlgorithm.EqualSplitAlgorithm;
import Examples.Splitwise.model.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InvalidExpenseException, InvalidExpenseException {
        User alice = new User("U1", "Alice");
        User bob = new User("U2", "Bob");
        User charlie = new User("U3", "Charlie");

        System.out.println(alice);
        System.out.println(bob);
        System.out.println(charlie);

        List<User> groupMembers = Arrays.asList(alice, bob, charlie);
        Group tripGroup = alice.createGroup(groupMembers, "G1", "Goa Trip", "Trip to Goa");
        System.out.println(tripGroup);

        ExpenseDTO personalExpenseDTO = new DirectExpenseDTO();
        personalExpenseDTO.setCreatedBy(alice);
        personalExpenseDTO.setAmount(new BigDecimal("1000"));
        personalExpenseDTO.setSplitAlgorithm(new EqualSplitAlgorithm());
        personalExpenseDTO.setParticipants(List.of(new Paid(alice), new Paid(bob)));

        Expense personalExpense = alice.createExpense(alice,personalExpenseDTO);
        System.out.println("Personal Expense: " + personalExpense);
        System.out.println(alice.printBalanceSheet());

        ExpenseDTO groupExpenseDTO = new GroupExpenseDTO(tripGroup);
        groupExpenseDTO.setCreatedBy(bob);
        groupExpenseDTO.setAmount(new BigDecimal("3000"));
        groupExpenseDTO.setSplitAlgorithm(new EqualSplitAlgorithm());
        groupExpenseDTO.setParticipants(List.of(new Paid(alice), new Paid(bob), new Paid(charlie)));

        Expense groupExpense = tripGroup.createExpense(groupExpenseDTO);
        System.out.println("Group Expense: " + groupExpense);
        System.out.println(alice.printBalanceSheet());

    }
}

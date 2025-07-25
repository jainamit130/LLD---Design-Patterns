package Examples.Splitwise;

import Examples.Splitwise.ExceptionHandling.InvalidExpenseException;
import Examples.Splitwise.model.Balance.Paid;
import Examples.Splitwise.model.Expense.Expense;
import Examples.Splitwise.model.Expense.ExpenseRequestDTO.DirectExpenseDTO;
import Examples.Splitwise.model.Expense.ExpenseRequestDTO.GroupExpenseDTO;
import Examples.Splitwise.model.Group;
import Examples.Splitwise.model.SplitAlgorithm.EqualSplitAlgorithm;
import Examples.Splitwise.model.User;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class SplitwiseApplication {

    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Group> groups = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public void start() throws InvalidExpenseException {
        while (true) {
            System.out.println("""
                \n--- Splitwise Console ---
                1. Create User
                2. Create Group
                3. Add Personal Expense
                4. Add Group Expense
                5. Settle Balance
                6. View Balance Sheet
                7. Show All Users
                8. Show All Groups
                9. Exit
                Choose option: """);

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> createUser();
                case 2 -> createGroup();
                case 3 -> addPersonalExpense();
                case 4 -> addGroupExpense();
                case 5 -> settleBalance();
                case 6 -> viewBalanceSheet();
                case 7 -> printAllUsers();
                case 8 -> printAllGroups();
                case 9 -> {
                    System.out.println("Exiting Splitwise App. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void createUser() {
        System.out.print("Enter user ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        users.put(id, new User(id, name));
        System.out.println("User created: " + name);
    }

    private void createGroup() {
        System.out.print("Enter group ID: ");
        String groupId = scanner.nextLine();
        System.out.print("Enter group name: ");
        String name = scanner.nextLine();
        System.out.print("Enter description: ");
        String desc = scanner.nextLine();

        System.out.print("Enter creator user ID: ");
        User creator = getUser(scanner.nextLine());

        System.out.print("Enter comma-separated user IDs for group members: ");
        List<User> members = new ArrayList<>();
        for (String uid : scanner.nextLine().split(",")) {
            members.add(getUser(uid.trim()));
        }

        Group group = creator.createGroup(members, groupId, name, desc);
        groups.put(groupId, group);
        System.out.println("Group created: " + name);
    }

    private void addPersonalExpense() throws InvalidExpenseException {
        System.out.print("Enter user ID creating expense: ");
        User creator = getUser(scanner.nextLine());

        System.out.print("Enter amount: ");
        BigDecimal amount = new BigDecimal(scanner.nextLine());

        System.out.print("Enter name of expense: ");
        String name = scanner.nextLine();

        List<Paid> paidList = readPaidUsers();

        DirectExpenseDTO dto = new DirectExpenseDTO(
                UUID.randomUUID().toString(), name,
                new EqualSplitAlgorithm(),
                amount,
                paidList,
                creator
        );

        Expense e = creator.createExpense(creator, dto);
        System.out.println("Expense created:\n" + e);
    }

    private void addGroupExpense() throws InvalidExpenseException {
        System.out.print("Enter group ID: ");
        Group group = getGroup(scanner.nextLine());
        if (group == null) {
            System.out.println("⚠️ Cancelled adding group expense.");
            return;
        }

        System.out.print("Enter user ID creating expense: ");
        User creator = getUser(scanner.nextLine());
        if (creator == null) {
            System.out.println("⚠️ Cancelled adding group expense.");
            return;
        }

        System.out.print("Enter amount: ");
        BigDecimal amount = new BigDecimal(scanner.nextLine());

        System.out.print("Enter name of expense: ");
        String name = scanner.nextLine();

        List<Paid> paidList = readPaidUsers();
        if (paidList == null) {
            System.out.println("⚠️ Cancelled adding group expense.");
            return;
        }

        GroupExpenseDTO dto = new GroupExpenseDTO(
                UUID.randomUUID().toString(), name,
                new EqualSplitAlgorithm(),
                amount,
                paidList,
                creator,
                group
        );

        Expense e = creator.createExpense(group, dto);
        System.out.println("✅ Group Expense created:\n" + e);
    }

    private void settleBalance() {
        System.out.print("Who is settling (payer user ID)? ");
        User payer = getUser(scanner.nextLine());

        System.out.print("To whom? (receiver user ID): ");
        User payee = getUser(scanner.nextLine());

        System.out.print("Amount: ");
        BigDecimal amount = new BigDecimal(scanner.nextLine());

        String result = payer.settleBalance(new Paid(payee, new AtomicReference<>(amount))).toString();
        System.out.println("Settlement Result: " + result);
    }

    private void viewBalanceSheet() {
        System.out.print("Enter user ID to view balance sheet: ");
        User user = getUser(scanner.nextLine());
        System.out.println(user.printBalanceSheet());
    }

    private List<Paid> readPaidUsers() {
        List<Paid> list = new ArrayList<>();
        System.out.print("Enter number of payers: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("User ID: ");
            User u = getUser(scanner.nextLine());
            if (u == null) return null;

            System.out.print("Amount paid: ");
            BigDecimal amt = new BigDecimal(scanner.nextLine());

            list.add(new Paid(u, new AtomicReference<>(amt)));
        }
        return list;
    }

    private User getUser(String id) {
        while (true) {
            if (id.equalsIgnoreCase("back")) return null;

            User user = users.get(id);
            if (user != null) return user;

            System.out.println("User not found: " + id);
            System.out.print("Please enter a valid user ID (or type 'back' to cancel): ");
            id = scanner.nextLine();
        }
    }

    private Group getGroup(String id) {
        while (true) {
            if (id.equalsIgnoreCase("back")) return null;

            Group group = groups.get(id);
            if (group != null) return group;

            System.out.println("Group not found: " + id);
            System.out.print("Please enter a valid group ID (or type 'back' to cancel): ");
            id = scanner.nextLine();
        }
    }

    private void printAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }
        System.out.println("\n--- All Users ---");
        for (User user : users.values()) {
            System.out.println("ID: " + user.getUserId() + ", Name: " + user.getName());
        }
    }

    private void printAllGroups() {
        if (groups.isEmpty()) {
            System.out.println("No groups found.");
            return;
        }
        System.out.println("\n--- All Groups ---");
        for (Group group : groups.values()) {
            System.out.println("ID: " + group.getGroupId() + ", Name: " + group.getGroupName() +
                    ", Description: " + group.getGroupDesc());
        }
    }

}

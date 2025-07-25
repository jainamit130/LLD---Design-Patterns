package Examples.Splitwise.model.SplitAlgorithm;

import Examples.Splitwise.model.Balance.*;
import Examples.Splitwise.model.Expense.Expense;
import Examples.Splitwise.model.Split;
import Examples.Splitwise.model.SplitType;
import Examples.Splitwise.model.User;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicReference;

public abstract class SplitAlgorithm {
    protected Expense expense;
    protected final PriorityQueue<Owe> owers = new PriorityQueue<>((lhs, rhs)->{
        return rhs.getAmount().get().compareTo(lhs.getAmount().get());
    });
    protected final PriorityQueue<Borrow> borrowers = new PriorityQueue<>((lhs,rhs)->{
        return lhs.getAmount().get().compareTo(rhs.getAmount().get());
    });

    protected SplitAlgorithm() {
    }

    public abstract boolean validate();
    public abstract SplitType getSplitType();
    public abstract Split getValidSplit(User user);

    public Map<User,Split> getValidSplits() {
        List<Paid> participants = expense.getParticipants();
        int size = participants.size();
        Map<User,Split> splits = new HashMap<>();
        for(int i=0;i<size;i++) splits.put(participants.get(i).getUser(),getValidSplit(participants.get(i).getUser()));
        return splits;
    }

    public final void processBalance() {
        populatePriorityQueues();
        processBalanceSheet();
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    private void setBalance(User user, Balance balance) {
        BalanceSheet balanceSheet = expense.getExpenseBalanceSheet().getOrDefault(user, new BalanceSheet());
        balanceSheet.setBalance(balance);
        user.addBalance(balance);
    }

    private void populatePriorityQueues() {
        for(Paid payer: expense.getParticipants()) {
            User user = payer.getUser();
            BigDecimal owedOrBorrowed = payer.getSignedAmount().subtract(expense.getSplit(user).getAmount());
            if(owedOrBorrowed.compareTo(BigDecimal.ZERO) > 0) owers.add(new Owe(user,new AtomicReference<>(owedOrBorrowed.abs())));
            else borrowers.add(new Borrow(user,new AtomicReference<>(owedOrBorrowed.abs())));
        }
    }

    private void processBalanceSheet() {
        while(!owers.isEmpty()) {
            Owe owe = owers.poll();
            User ower = owe.getUser();
            BigDecimal owedAmount = owe.getAmount().get();
            while(!borrowers.isEmpty() && owedAmount.compareTo(BigDecimal.ZERO)>0) {
                Borrow borrow = borrowers.poll();
                User borrower = borrow.getUser();
                BigDecimal borrowedAmount = borrow.getAmount().get().abs();
                BigDecimal transferBalance = borrowedAmount.min(owedAmount);
                // owe in ower
                setBalance(ower,new Owe(borrower,new AtomicReference<>(transferBalance)));
                // borrow in borrower
                setBalance(borrower,new Borrow(ower,new AtomicReference<>(transferBalance)));
                owedAmount = owedAmount.subtract(transferBalance);
                borrowedAmount = borrowedAmount.subtract(transferBalance);
                if(borrowedAmount.compareTo(BigDecimal.ZERO)>0) borrowers.add(borrow);
                if(owedAmount.equals(BigDecimal.ZERO)) break;
            }
        }
    }
}


/*






* */
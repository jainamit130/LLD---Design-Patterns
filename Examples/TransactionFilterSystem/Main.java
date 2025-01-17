package Examples.TransactionFilterSystem;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", "C1", 1673673600L, 100.0),
                new Transaction("T2", "C2", 1673677200L, 200.0),
                new Transaction("T3", "C1", 1673680800L, 150.0),
                new Transaction("T4", "C3", 1673684400L, 50.0)
        );

        TransactionFilteringSystem system = new TransactionFilteringSystem(transactions);

        List<TransactionFilter> filters = Arrays.asList(
                Filters.byCustomerId("C1"),
                Filters.byStartAndEndTime(1673670000L, 1673680799L)
        );

        List<Transaction> filteredTransactions = system.filterTransactions(filters);

        filteredTransactions.forEach(transaction ->
                System.out.println("Transaction ID: " + transaction.getTransactionId())
        );
    }
}


package Examples.TransactionFilterSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TransactionFilteringSystem {
    private final List<Transaction> transactions;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public TransactionFilteringSystem(List<Transaction> transactions) {
        this.transactions = new ArrayList<>(transactions);
    }

    public List<Transaction> filterTransactions(List<TransactionFilter> filters) {
        lock.readLock().lock();
        try {
            List<Transaction> result = new ArrayList<>(transactions);
            for (TransactionFilter filter : filters) {
                result.removeIf(transaction -> !filter.apply(transaction));
            }
            return result;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void addTransaction(Transaction transaction) {
        lock.writeLock().lock();
        try {
            transactions.add(transaction);
        } finally {
            lock.writeLock().unlock();
        }
    }
}

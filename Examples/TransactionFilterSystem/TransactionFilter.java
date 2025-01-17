package Examples.TransactionFilterSystem;

@FunctionalInterface
public interface TransactionFilter {
    boolean apply(Transaction transaction);
}

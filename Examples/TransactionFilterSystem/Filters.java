package Examples.TransactionFilterSystem;

public class Filters {

    public static TransactionFilter byCustomerId(String customerId) {
        return transaction -> transaction.getCustomerId().equals(customerId);
    }

    public static TransactionFilter byStartAndEndTime(long start, long end) {
        return transaction -> transaction.getTimestamp() >= start && transaction.getTimestamp() <= end;
    }

    public static TransactionFilter byMinimumAmount(double minAmount) {
        return transaction -> transaction.getAmount() >= minAmount;
    }
}


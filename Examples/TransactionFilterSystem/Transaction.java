package Examples.TransactionFilterSystem;

public class Transaction {
    private final String transactionId;
    private final String customerId;
    private final long timestamp; // Unix timestamp for start and end filtering
    private final double amount;

    public Transaction(String transactionId, String customerId, long timestamp, double amount) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.timestamp = timestamp;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getAmount() {
        return amount;
    }
}

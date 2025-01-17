package Examples.ParkingSystem;

import Examples.ParkingSystem.StatePattern.BillStatus;

import java.util.List;

public class Bill {
    private String billId;
    private String tokenId;
    List<Transaction> transactions;
    private Integer amount;
    private Integer paidAmount;
    private BillStatus status;

    private void payAmount(Integer paidAmount) {
        this.paidAmount += paidAmount;
    }

    private void refundAmount(Integer refundAmount) {
        this.paidAmount -= refundAmount;
    }


}

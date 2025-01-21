package Examples.ParkingSystem;

import Examples.ParkingSystem.Pricing.PricingStrategyFactory;
import Examples.ParkingSystem.StatePattern.Bill.Bill;

public class ExitGate {
    private String exitGateId;
    private EntryGate entryGate;

    public ExitGate(String exitGateId, EntryGate entryGate) {
        this.exitGateId = exitGateId;
        this.entryGate = entryGate;
        this.entryGate.setExitGate(this);
    }

    public Bill process(Token token) {
        return generateBill(token);
    }

    private Bill generateBill(Token token) {
        deallocateSpot(token.getCarNum());
        PricingStrategyFactory pricingStrategyFactory = new PricingStrategyFactory();
        return new Bill(pricingStrategyFactory.getPricingStrategy(token.getType()),token.getEntryTime());
    }

    private void deallocateSpot(String carNum) {
        entryGate.deallocateSpot(carNum);
    }
}

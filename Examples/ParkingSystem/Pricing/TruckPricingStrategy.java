package Examples.ParkingSystem.Pricing;

import java.time.Instant;

public class TruckPricingStrategy implements PricingStrategy {
    @Override
    public Double calculatePrice(Instant parkTime) {
        int parkDurationSeconds = Instant.now().compareTo(parkTime);
        return parkDurationSeconds*0.50;
    }
}

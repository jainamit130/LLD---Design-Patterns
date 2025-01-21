package Examples.ParkingSystem.Pricing;

import java.time.Instant;

public interface PricingStrategy {
    Double calculatePrice(Instant parkTime);
}

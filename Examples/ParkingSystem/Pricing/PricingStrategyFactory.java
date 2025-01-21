package Examples.ParkingSystem.Pricing;

import Examples.ParkingSystem.Exceptions.NoAvailablePricingStrategyException;
import Examples.ParkingSystem.ParkingType;

public class PricingStrategyFactory {

    public PricingStrategy getPricingStrategy(ParkingType parkingType) {
        switch (parkingType) {
            case TRUCK:
                return new TruckPricingStrategy();
            case CAR:
                return new FourWheelerPricingStrategy();
            case THREE_WHEELER:
                return new ThreeWheelerPricingStrategy();
            case TWO_WHEELER:
                return new TwoWheelerPricingStrategy();
            default:
                throw new NoAvailablePricingStrategyException();
        }
    }
}


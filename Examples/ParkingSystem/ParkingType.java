package Examples.ParkingSystem;

public enum ParkingType {
    TWO_WHEELER(1),
    THREE_WHEELER(2),
    CAR(3),
    TRUCK(4);

    private final int priority;

    ParkingType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public static ParkingType getNextType(ParkingType currentType) {
        for (ParkingType type : ParkingType.values()) {
            if (type.getPriority() == currentType.getPriority() + 1) {
                return type;
            }
        }
        return null;
    }
}


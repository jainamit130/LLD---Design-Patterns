package Examples.ParkingSystem;

import java.time.Instant;

public class Token {
    private String tokenId;
    private Parker parker;
    private String parkingSpotId;
    private ParkingType type;
    private String carNum;
    private Instant entryTime;

    public Token(Parker parker, String carNum, String parkingSpotId, ParkingType type, Instant entryTime) {
        this.parker = parker;
        this.carNum = carNum;
        this.parkingSpotId = parkingSpotId;
        this.type = type;
        this.entryTime = entryTime;
    }

    public String getCarNum() {
        return carNum;
    }

    public ParkingType getType() {
        return type;
    }

    public Instant getEntryTime() {
        return entryTime;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenId='" + tokenId + '\'' +
                ", parker=" + parker +
                ", parkingSpotId='" + parkingSpotId + '\'' +
                ", type=" + type +
                ", carNum='" + carNum + '\'' +
                ", entryTime=" + entryTime +
                '}';
    }
}

package Examples.ParkingSystem;

public class WeightedItem {
    private Integer weight;
    private String id;
    private ParkingType type;

    public WeightedItem(Integer weight, String id, ParkingType type) {
        this.weight = weight;
        this.id = id;
        this.type=type;
    }

    public Integer getWeight() {
        return weight;
    }

    public ParkingType getType() {
        return type;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

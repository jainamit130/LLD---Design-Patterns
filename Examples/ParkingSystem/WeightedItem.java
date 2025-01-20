package Examples.ParkingSystem;

public class WeightedItem {
    private Integer weight;
    private String id;

    public WeightedItem(Integer weight, String id) {
        this.weight = weight;
        this.id = id;
    }

    public Integer getWeight() {
        return weight;
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

package Examples.ElevatorSystem.Entities.Button;

public class FloorButton implements IButton{
    private int floorNum;

    public FloorButton(int floorNum) {
        this.floorNum = floorNum;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    @Override
    public void press() {

    }
}

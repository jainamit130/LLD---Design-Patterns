package Examples.ElevatorSystem.Entities;

import Examples.ElevatorSystem.Entities.Button.Button;

import java.util.List;

public class Elevator {
    private int floors;
    private int currentFloor;
    private Board internalBoard;

    public Elevator(int floors) {
        currentFloor = 0;
        this.floors = floors;
    }

    public void addButtons(List<Button> buttons) {
        internalBoard.addButtons(buttons);
    }

    public void moveTo(int floor) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Dropping at floor: " + floor);
    }


    /*
    * Take pending floor
    * traverse all the elevators
    * get min time to reach for each elevator
    *
    *
    *
    *
    * */
}

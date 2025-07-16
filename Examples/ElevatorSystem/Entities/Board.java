package Examples.ElevatorSystem.Entities;

import Examples.ElevatorSystem.Entities.Button.Button;
import Examples.ElevatorSystem.Entities.Button.IButton;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Board {
    private final Set<IButton> buttons;

    public Board() {
        this.buttons = new HashSet<>();
    }

    public void addButtons(List<Button> buttons) {
        this.buttons.addAll(buttons);
    }

    public void pressButton(IButton button) {
        if(buttons.contains(button)) button.press();
    }
}

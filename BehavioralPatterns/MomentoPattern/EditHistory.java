package BehavioralPatterns.MomentoPattern;

import java.util.ArrayList;
import java.util.List;

class EditHistory {
    private final List<Editor.Memento> history = new ArrayList<>();
    private Integer index = -1;

    private void add(Editor.Memento memento) {
        history.add(memento);
        index++;
    }

    public void save(Editor.Memento memento) {
        if(index!=-1) {
            while(history.size()>index+1) {
                history.removeLast();
            }
        }
        this.add(memento);
    }

    public Editor.Memento undo() {
        if(index>0) {
            index -= 1;
        } else {
            throw new IllegalStateException("No previous states to undo.");
        }
        return this.get(index);
    }

    public Editor.Memento redo() {
        if(index < history.size()-1) {
            index++;
        } else {
            throw new IllegalStateException("No future states to redo.");
        }
        return this.get(index);
    }

    public Editor.Memento get(int index) {
        return history.get(index);
    }
}
package BehavioralPatterns.MomentoPattern;

public class Editor {
    private String text;
    private String format;
    private EditHistory history;

    public Editor(String text, String format) {
        this.history = new EditHistory();
        this.save(text, format);
    }

    public void printState() {
        System.out.println("Current State: "+this.text+" - "+this.format);
    }

    public void save(String text,String format) {
        history.save(new Memento(text, format));
        this.text = text;
        this.format = format;
    }

    public void undo() {
        Editor.Memento memento = history.undo();
        this.text = memento.getText();
        this.format = memento.getFormat();
    }

    public void redo() {
        Editor.Memento memento = history.redo();
        this.text = memento.getText();
        this.format = memento.getFormat();
    }


    public static class Memento {
        private final String text;
        private final String format;

        private Memento(String text, String format) {
            this.text = text;
            this.format = format;
        }

        public String getText() {
            return text;
        }

        public String getFormat() {
            return format;
        }

    }
}

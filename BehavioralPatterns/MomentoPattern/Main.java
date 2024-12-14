package BehavioralPatterns.MomentoPattern;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor("text0","format0");
        // 0 -> 1 -> 2 -> 3 -> 4 -> 5
        for(int i=1;i<=5;i++) {
            editor.save("text"+i,"format"+i);
        }
        editor.printState(); // 5

        // 5 -> 4 -> 3
        for(int i=1;i<=2;i++) {
            editor.undo();
        }

        editor.printState(); // 3

        // 3 -> 4' -> 5'
        for(int i=4;i<=5;i++) {
            editor.save("text"+i+"'","format"+i+"'");
        }

        editor.printState(); // 5'

        // 5' -> 4' -> 3 -> 2
        for(int i=1;i<=3;i++) {
            editor.undo();
        }

        editor.printState(); // 2

        // 2 -> 3 -> 4'
        for(int i=1;i<=2;i++) {
            editor.redo();
        }

        editor.printState(); // 4'
    }
}

package BehavioralPatterns.IteratorPattern;

public interface Iterator<T> {
    boolean hasNext();
    Node<T> getNext();
    void reset();
    default void traverse() {
        System.out.println(this.getClass().getSimpleName()+" Traversal");
        while(hasNext()) {
            System.out.print(getNext().getVal() + " -> ");
        }
        System.out.println("null");
    }
}

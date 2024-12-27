package BehavioralPatterns.IteratorPattern;

import java.util.LinkedList;
import java.util.List;

public class Node<T> {

    private final T val;

    private boolean visited;

    private List<Node<T>> neighbors = new LinkedList<>();

    public Node(T val) {
        this.val = val;
        visited=false;
    }

    public boolean isVisited() {
        return visited;
    }

    public T getVal() {
        return val;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Node<T>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node<T>> neighbors) {
        this.neighbors = neighbors;
    }
}

package BehavioralPatterns.IteratorPattern.ConcreteIterator;

import BehavioralPatterns.IteratorPattern.Iterator;
import BehavioralPatterns.IteratorPattern.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstIterator<T> implements Iterator<T> {

    private final Node<T> source;
    private final Queue<Node<T>> queue = new LinkedList<>();

    public BreadthFirstIterator(Node<T> source) {
        this.source = source;
        queue.add(source);
    }

    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }

    @Override
    public Node getNext() {

        if(!hasNext()) {
            return null;
        }

        Node<T> node = queue.poll();
        if(!node.isVisited()) {
            node.setVisited(true);
            node.getNeighbors().forEach(queue::add);
            return node;
        }
        return getNext();
    }

    @Override
    public void reset() {
        queue.clear();
        queue.add(source);
        resetVisited();
    }

    private void resetVisited() {
        // Traverse and reset visited flag for all nodes (if needed)
        // Here it assumes all nodes are accessible from the source, if not, you'd need a full graph traversal
        Queue<Node<T>> tempQueue = new LinkedList<>();
        tempQueue.add(source);
        while (!tempQueue.isEmpty()) {
            Node<T> current = tempQueue.poll();
            if (current.isVisited()) {
                current.setVisited(false);
                current.getNeighbors().forEach(tempQueue::add);
            }
        }
    }
}

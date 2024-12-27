package BehavioralPatterns.IteratorPattern.ConcreteIterator;

import BehavioralPatterns.IteratorPattern.Iterator;
import BehavioralPatterns.IteratorPattern.Node;

import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstIterator<T> implements Iterator<T> {

    private final Node<T> source;
    private final Deque<Node<T>> stack = new LinkedList<>();

    public DepthFirstIterator(Node<T> source) {
        this.source = source;
        stack.push(source);
    }


    @Override
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

    @Override
    public Node<T> getNext() {
        if(!hasNext()) {
            return new Node(-1);
        }

        Node<T> node = stack.pop();
        if(!node.isVisited()) {
            node.setVisited(true);
            node.getNeighbors().forEach(stack::push);
            return node;
        }
        return getNext();
    }

    @Override
    public void reset() {
        stack.clear();
        stack.push(source);
        resetVisited();
    }

    private void resetVisited() {
        // Traverse and reset visited flag for all nodes (if needed)
        // Here it assumes all nodes are accessible from the source, if not, you'd need a full graph traversal
        Deque<Node<T>> tempStack = new LinkedList<>();
        tempStack.push(source);
        while (!tempStack.isEmpty()) {
            Node<T> current = tempStack.pop();
            if (current.isVisited()) {
                current.setVisited(false);
                current.getNeighbors().forEach(tempStack::push);
            }
        }
    }
}

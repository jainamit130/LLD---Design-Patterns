package BehavioralPatterns.IteratorPattern;

import BehavioralPatterns.IteratorPattern.ConcreteIterator.BreadthFirstIerator;
import BehavioralPatterns.IteratorPattern.ConcreteIterator.DepthFirstIterator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n6 = new Node<>(6);

        n1.setNeighbors(List.of(n2,n4));
        n4.setNeighbors(List.of(n3,n6,n5));

        Iterator<Integer> dfs = new DepthFirstIterator<>(n1);
        dfs.traverse();
        dfs.reset();
        Iterator<Integer> bfs = new BreadthFirstIerator<>(n1);
        bfs.traverse();
        bfs.reset();
    }
}

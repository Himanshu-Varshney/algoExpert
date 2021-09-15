package algoexpert.io.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    static class Node{
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name){
            this.name = name;
        }

        public Node addChild(String name){
            Node child = new Node(name);
            this.children.add(child);
            return this;
        }

        public List<String> breadthFirstSearch(List<String> array){
            Queue<Node> queue = new LinkedList();
            queue.add(this);
            Node currentNode = null;
            while (!queue.isEmpty()){
                currentNode = queue.remove();// or currentNode = queue.poll() , anything is fine, remove throws an exception if queue is empty
                array.add(currentNode.name);
                List<Node> childs =currentNode.children;
                queue.addAll(currentNode.children);
                }

            return array;
        }
    }
}

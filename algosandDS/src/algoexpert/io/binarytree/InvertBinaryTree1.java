package algoexpert.io.binarytree;

import java.util.ArrayDeque;

public class InvertBinaryTree1 {

    public static void invertBinaryTree(BinaryTree tree) {
        ArrayDeque<BinaryTree> queue = new ArrayDeque<BinaryTree>();
        queue.addLast(tree);

        while (queue.size()>0){
            BinaryTree current = queue.pollFirst();
            swapLeftAndRight(current);
            if(current.left != null){
                queue.addLast(current.left);
            }
            if(current.right != null){
                queue.addLast(current.right);
            }

        }
    }

    private static void swapLeftAndRight(BinaryTree current) {
        BinaryTree left = current.left;
        current.left = current.right;
        current.right = left;
    }

    static class BinaryTree{
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value){
            this.value=value;
        }
    }
}

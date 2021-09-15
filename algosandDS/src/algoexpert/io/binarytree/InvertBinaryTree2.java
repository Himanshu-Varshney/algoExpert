package algoexpert.io.binarytree;

public class InvertBinaryTree2 {

    public static void invertBinaryTree(BinaryTree tree) {
       if(tree == null)
           return;
        swapLeftAndRight(tree);
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);

    }
    private static void swapLeftAndRight(BinaryTree current) {
       BinaryTree left = current.left;
        current.left = current.right;
        current.right = left;
    }
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}

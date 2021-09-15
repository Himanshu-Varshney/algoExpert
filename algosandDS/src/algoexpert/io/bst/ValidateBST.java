package algoexpert.io.bst;

public class ValidateBST {
    public static boolean validateBst(BST tree) {
        return validateBst(tree,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

        /*
        To validate if tree is valid BST , if it is left child then it should be strictly less than parent node's value,
        and if it is right child it should be greater than or equal to it's parent node values.
        In short there is range of values in which every node should lie.
         */

    public static boolean validateBst(BST tree,int minVal,int maxVal){
        if(tree == null)
            return true;
        if(tree.value < minVal || tree.value>=maxVal)
            return false;
        return validateBst(tree.left,minVal, tree.value) && validateBst(tree.right, tree.value, maxVal);
    }


    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}

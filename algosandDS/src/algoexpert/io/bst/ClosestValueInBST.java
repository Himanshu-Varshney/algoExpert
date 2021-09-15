package algoexpert.io.bst;

import org.junit.Test;

public class ClosestValueInBST {

    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        return findClosestValueInBst(tree,target,Integer.MAX_VALUE,-1);
    }

    public static int findClosestValueInBst(BST tree, int target,int currDiff,int nodeVal) {
        // Write your code here.
        if (tree==null)
            return -1;
        int diff = Math.abs(tree.value - target);
        if(diff < currDiff){
            currDiff = diff;
            nodeVal = tree.value;
        }
        // if tree.value < target , then absolute difference of all left nodes will be more, therefore go to right side
        if(tree.value < target && tree.right!=null){
            return findClosestValueInBst(tree.right,target,currDiff,nodeVal);
        }else if (tree.value>target && tree.left!=null){
            return findClosestValueInBst(tree.left,target,currDiff,nodeVal);
        }else{
            return nodeVal;
        }
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

package algoexpert.io.bst;

import java.util.ArrayList;
import java.util.List;


/*
Idea : Inorder traversal of BST prints the value in sorted order [ascending]
 */
public class KthLargestValue {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {

        List<Integer> sortedVals = new ArrayList<>();
        findKthLargestValueInBst(tree,k,sortedVals);
        return sortedVals.get(sortedVals.size()-k);
    }

    private void findKthLargestValueInBst(BST node, int k, List<Integer> sortedVals) {
        if(node == null)
            return;
        //Do inorder traversal
        findKthLargestValueInBst(node.left,k,sortedVals);
        sortedVals.add(node.value);
        findKthLargestValueInBst(node.right,k,sortedVals);
    }
}

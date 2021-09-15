package algoexpert.io.bst;

import java.util.ArrayList;
import java.util.List;

/*
Idea : Reverse Inorder traversal of BST prints the value in sorted order [descending]
 */
public class KthLargestValue2 {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    static class TreeInfo{
        int lastVisitedNodeVal;
        int nodesVisitedSoFar;

        public TreeInfo(int lastVisitedNodeVal, int nodesVisitedSoFar) {
            this.lastVisitedNodeVal = lastVisitedNodeVal;
            this.nodesVisitedSoFar = nodesVisitedSoFar;
        }
    }
    public int findKthLargestValueInBst(BST tree, int k) {

        TreeInfo treeInfo = new TreeInfo(-1,0);
        findKthLargestValueInBst(tree,k,treeInfo);
        return treeInfo.lastVisitedNodeVal;
    }

    private void findKthLargestValueInBst(BST node, int k, TreeInfo treeInfo) {
        if(node == null || treeInfo.nodesVisitedSoFar>=k)
            return;
        //Do reverse inorder traversal
        findKthLargestValueInBst(node.right,k,treeInfo);
        if(treeInfo.nodesVisitedSoFar<k){
            treeInfo.nodesVisitedSoFar +=1;
            treeInfo.lastVisitedNodeVal=node.value;
            findKthLargestValueInBst(node.left,k,treeInfo);
        }

    }
}

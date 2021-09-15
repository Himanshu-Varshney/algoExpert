package algoexpert.io.bst;

import java.util.ArrayList;
import java.util.List;

public class ReconstructBST1 {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
       if(preOrderTraversalValues.isEmpty())
           return null;

       int currentVal = preOrderTraversalValues.get(0);
       int rightSubtreeIdx = preOrderTraversalValues.size();

       for(int i=1;i<preOrderTraversalValues.size();i++){
           if(preOrderTraversalValues.get(i)>=currentVal){
               rightSubtreeIdx=i;
               break;
           }
       }

       BST leftSubtreeNode = reconstructBst(preOrderTraversalValues.subList(1,rightSubtreeIdx));
       BST rightSubtreeNode = reconstructBst(preOrderTraversalValues.subList(rightSubtreeIdx,preOrderTraversalValues.size()));

       BST bst = new BST(currentVal);
       bst.left = leftSubtreeNode;
       bst.right = rightSubtreeNode;
       return bst;
    }
}

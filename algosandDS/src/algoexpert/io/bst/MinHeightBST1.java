package algoexpert.io.bst;

import java.util.List;

public class MinHeightBST1 {

    public static BST minHeightBst(List<Integer> array) {

        return constructMinHeightBST(array,null,0,array.size()-1);
    }

    public static BST constructMinHeightBST(List<Integer> arr, BST bst, int startIndx,int endIndx){

        if(endIndx <startIndx)
            return null;

        int midIndx = (int)Math.floor((startIndx+endIndx)/2);
        Integer midVal = arr.get(midIndx);
        if(bst == null){
            bst = new BST(midVal);
        }else{
            bst.insert(midVal);
        }
        constructMinHeightBST(arr,bst,startIndx,midIndx-1);
        constructMinHeightBST(arr,bst,midIndx+1,endIndx);
        return bst;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}

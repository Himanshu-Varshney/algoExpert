import java.util.List;

public class MinHeightBST3 {

    public static BST minHeightBst(List<Integer> array) {

        return constructMinHeightBST(array,0,array.size()-1);
    }

    public static BST constructMinHeightBST(List<Integer> arr, int startIndx,int endIndx){

        if(endIndx <startIndx)
            return null;

        int midIndx = (int)Math.floor((startIndx+endIndx)/2);
        Integer midVal = arr.get(midIndx);
        BST bst = new BST(midVal);
        bst.left=constructMinHeightBST(arr,startIndx,midIndx-1);
        bst.right=constructMinHeightBST(arr,midIndx+1,endIndx);
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

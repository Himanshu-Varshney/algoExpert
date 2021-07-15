import java.util.List;

public class MinHeightBST2 {

    public static BST minHeightBst(List<Integer> array) {

        return constructMinHeightBST(array,null,0,array.size()-1);
    }

    public static BST constructMinHeightBST(List<Integer> arr, BST bst, int startIndx,int endIndx){

        if(endIndx <startIndx)
            return null;

        int midIndx = (int)Math.floor((startIndx+endIndx)/2);
        Integer midVal = arr.get(midIndx);
        BST newBSTNode = new BST(midVal);
        if(bst == null){
            bst = newBSTNode;
        }else{
            if(midVal< bst.value){
                bst.left = newBSTNode;
                bst = newBSTNode;
            }else{
                bst.right = newBSTNode;
                bst = newBSTNode;
            }
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

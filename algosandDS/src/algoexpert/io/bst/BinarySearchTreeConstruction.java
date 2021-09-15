package algoexpert.io.bst;

public class BinarySearchTreeConstruction {

    static class BST{
         int value;
         BST left;
         BST right;

         public BST(int value){
             this.value = value;
         }

         /*
         Inserts value in Binary Search tree
           Average = O(log(n)) time | space = O(log(n))
           Worst = O(n) time | space = O(n)
          */
         public BST insert(int value){
             if(value < this.value){
                 if(this.left == null){
                     BST newBST = new BST(value);
                     this.left = newBST;
                 }else{
                     this.left.insert(value);
                 }
             }else{
                 if(this.right == null){
                     BST newBST = new BST(value);
                     this.right = newBST;
                 }else{
                     this.right.insert(value);
                 }
             }
             return this;
         }

         /*
         Search whether a value is present in BST
         Average = O(log(n)) time | space = O(log(n))
         Worst = O(n) time | space = O(n)
          */
        public boolean contains(int value){
             if(value == this.value)
                 return true;
             else if (value < this.value) {
                 if(this.left == null)
                     return false;
                 else
                     return this.left.contains(value);
             }
             else {
                 if(this.right == null)
                     return false;
                 else
                     return this.right.contains(value);
             }
        }

        /*
        Returns min value in BST.
        Minimum value will be in left side of BST.
        In short it keeps on traversing to left most part of tree, until the left
        part of the tree is null. The leftmost node contains the minimum value
         */
        public int getMinValue(){
            if(this.left == null)
                return this.value;
            else{
                return this.left.getMinValue();
            }
        }

        public BST remove(int value){
            remove(value,null);
            return this;
        }

        public void remove(int value, BST parent){
            if(value < this.value){
                if(this.left != null){
                    this.left.remove(value,this);
                }
            }else if (value > this.value){
                if(this.right != null){
                    this.right.remove(value,this);
                }
            }else{
                //Node has both left and right child
                if(this.left != null && this.right != null){
                    //get Minimum value in the right subtree, and replace this value
                    //with node's value
                    this.value = this.right.getMinValue();
                    //then remove the minimum value taken from right subtree
                    this.right.remove(this.value,this);
                }//Only 1 child node but parent is null (eg root node with only 1 child,
                //replace left child node or right child node
                else if (parent ==null){
                    if(this.left != null){
                        this.value = this.left.value;
                        this.right = this.left.right;
                        this.left = this.left.left;
                    }else if(this.right != null){
                        this.value = this.right.value;
                        this.left = this.right.left;
                        this.right = this.right.right;
                    }
                }//parent node is present and only 1 child either left or right
                //current node is left child of parent
                else if (parent.left == this){
                    parent.left = this.left != null ? this.left : this.right;
                }/* or current node is right chiild of parent*/
                else if(parent.right == this){
                    parent.right = this.left != null ? this.left :this.right;
                }
            }

        }

    }

}

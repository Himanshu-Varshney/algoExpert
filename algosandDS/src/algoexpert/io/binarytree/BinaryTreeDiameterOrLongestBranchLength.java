package algoexpert.io.binarytree;

import sun.reflect.generics.tree.Tree;

public class BinaryTreeDiameterOrLongestBranchLength {

    public int binaryTreeDiameter(BinaryTree tree) {

        return getTreeInfo(tree).diameter;
    }


    public TreeInfo getTreeInfo(BinaryTree tree){
        if(tree == null)
            return new TreeInfo(0,0);

        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);

        int longestPathThroughNode = leftTreeInfo.height+ rightTreeInfo.height;
        int maxDiameterSoFar = Math.max(leftTreeInfo.diameter,rightTreeInfo.diameter);
        int currentDiameter = Math.max(maxDiameterSoFar,longestPathThroughNode);
        int currentHeight = Math.max(leftTreeInfo.height,rightTreeInfo.height)+1;
        return new TreeInfo(currentDiameter,currentHeight);

    }


    static class TreeInfo{
            int diameter;
            int height;

        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }


}

package algoexpert.io.graphs;

public class YoungestCommonAncestor {

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {

        int depthOne =getDescendantDepth(descendantOne,topAncestor);
        int depthTwo =getDescendantDepth(descendantTwo,topAncestor);

        if(depthOne>depthTwo){
            return trackYoungestCommonAncestor(descendantOne,descendantTwo,depthOne-depthTwo);
        }else{
            return trackYoungestCommonAncestor(descendantTwo,descendantOne,depthTwo-depthOne);
        }

    }

    private static AncestralTree trackYoungestCommonAncestor(AncestralTree smallDescendant, AncestralTree bigDescendant, int depth) {

        while (depth>0){
            smallDescendant = smallDescendant.ancestor;
            depth--;
        }

        while (smallDescendant != bigDescendant){
            smallDescendant=smallDescendant.ancestor;
            bigDescendant=bigDescendant.ancestor;
        }
        return smallDescendant;
    }

    private static int getDescendantDepth(AncestralTree descendant, AncestralTree topAncestor) {
        int depth =0;
        while (descendant != topAncestor) {
            depth++;
            descendant=descendant.ancestor;
        }
        return depth;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}

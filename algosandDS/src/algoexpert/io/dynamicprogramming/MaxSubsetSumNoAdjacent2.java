package algoexpert.io.dynamicprogramming;

public class MaxSubsetSumNoAdjacent2 {

    public static int maxSubsetSumNoAdjacent(int[] array) {
        if(array.length==0)
            return 0;
        else if(array.length==1)
            return array[0];

        int secondPrev = array[0];
        int firstPrev = Math.max(array[0],array[1]);
        int current = -1;
        for(int i=2;i<array.length;i++){
            current = Math.max(firstPrev,secondPrev+array[i]);
            secondPrev=firstPrev;
            firstPrev=current;
        }

        return firstPrev;
    }
}

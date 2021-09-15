package algoexpert.io.graphs;

public class SingleCycleCheck {

    public static boolean hasSingleCycle(int[] array) {
        int currentIdx = 0;
        int numberOfElementsVisited = 0;

        while (numberOfElementsVisited<array.length){
            if(numberOfElementsVisited>0 && currentIdx==0) {
                return false;
            }
            numberOfElementsVisited++;
            currentIdx = getNextIdx(currentIdx,array);

        }
        return currentIdx==0;
    }

    private static int getNextIdx(int currentIdx, int[] array) {
        int jump = array[currentIdx];
        int nextIdx = (currentIdx+jump)%array.length;
        return nextIdx>=0 ?nextIdx : nextIdx+array.length;
    }
}

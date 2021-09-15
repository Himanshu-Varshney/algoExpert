package algoexpert.io.sorting;

public class QuickSort {

    public static int[] quickSort(int[] array) {
        
        quickSortHelper(array,0,array.length-1);
        return array;
    }

    private static void quickSortHelper(int[] array, int startIdx, int endIdx) {
        if(startIdx>=endIdx)
            return;
        int pivot = startIdx;
        int leftIdx = startIdx+1;
        int rightIdx = endIdx;
        while (rightIdx>=leftIdx){
            if(array[leftIdx] > array[pivot] && array[rightIdx]<array[pivot]){
                swap(leftIdx,rightIdx,array);
            }
            if(array[leftIdx]<=array[pivot]){
                leftIdx++;
            }
            if(array[rightIdx]>=array[pivot]){
                rightIdx--;
            }
        }
        swap(pivot,rightIdx,array);
        //rightIdx is basically the pivot final position after swapping
        boolean isLeftSubArraySmaller = rightIdx -1 -startIdx < endIdx -(rightIdx+1);
        if(isLeftSubArraySmaller){
            quickSortHelper(array,startIdx,rightIdx-1);
            quickSortHelper(array,rightIdx+1,endIdx);
        }else{
            quickSortHelper(array,rightIdx+1,endIdx);
            quickSortHelper(array,startIdx,rightIdx-1);
        }
    }

    private static void swap(int leftIdx, int rightIdx, int[] array) {
        int temp =array[leftIdx];
        array[leftIdx]=array[rightIdx];
        array[rightIdx]=temp;
    }
}

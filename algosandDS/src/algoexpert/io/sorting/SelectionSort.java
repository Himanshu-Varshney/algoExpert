package algoexpert.io.sorting;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {
       if(array.length==0)
           return new int[]{};
       int startIdx=0;
       while (startIdx<array.length-1){
           int smallestIndx = startIdx;
           for(int i=startIdx+1;i<array.length;i++){
               if(array[smallestIndx]>array[i]){
                   smallestIndx=i;
               }
           }
           swap(startIdx,smallestIndx,array);
           startIdx++;
       }

        return array;
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}

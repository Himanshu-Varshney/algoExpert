package algoexpert.io.sorting;

public class InsertionSort {

    //O(N^2)|O(1)
    public static int[] insertionSort(int[] array) {
        if(array.length==0)
            return new int[]{};

        for(int i=1;i< array.length;i++){
            int j=i;
            while (j>0 && array[j]<array[j-1]) {
                swap(j, j - 1, array);
                j--;
            }
        }


        // Write your code here.
        return array;
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }

}

package algoexpert.io.sorting;

public class Bubblesort {

//O(N^2) | O(1)
    public static int[] bubbleSort(int[] array){
        if(array.length==0)
            return new int[]{};

        boolean isSorted=false;
        int counter=0;

        while (!isSorted){
           isSorted=true;
           for (int i=0;i<array.length-1-counter;i++){
               if(array[i]>array[i+1]){
                   swap(i,i+1,array);
                   isSorted=false;
               }
           }
           counter++;
        }

    return array;

    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}

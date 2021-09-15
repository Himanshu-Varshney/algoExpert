package algoexpert.io.arrays;

/*
Given an array and an element (present in array). Move all occurrences of tht elemnent in array
to the end of array.
{
  "array": [2, 1, 2, 2, 2, 3, 4, 2],
  "toMove": 2
}
 */

import java.util.Arrays;
import java.util.List;

public class MoveArrayElementsToEnd {


    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

        int start = 0;
        int end = array.size()-1;

        while(start<end){
            if(array.get(start)==toMove && array.get(end)!=toMove){
                //then swap elements
                array.set(start,array.get(end));
                array.set(end,toMove);
                start++;
                end--;
            }
            while(array.get(start)!=toMove && start<end)
                start++;

            while(array.get(end)==toMove && start<end)
                end--;

        }
        return array;
    }

    public static void main(String[] args) {
        MoveArrayElementsToEnd obj = new MoveArrayElementsToEnd();
        System.out.println(obj.moveElementToEnd(Arrays.asList(1,2,4,5,6),3));
    }
}

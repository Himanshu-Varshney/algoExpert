package algoexpert.io.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permuatations2 {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permuations = new ArrayList<>();
        getPermutations(0,array,permuations);
        return permuations;
    }

    private static void getPermutations(int i, List<Integer> array, List<List<Integer>> permuations) {
        if( i==array.size()-1){
            permuations.add(new ArrayList<>(array));
        }else{
            for(int j=i ;j< array.size();j++){
                swap(array,i,j);
                getPermutations(i+1,array,permuations);
                swap(array,i,j);
            }
        }
    }

    private static void swap(List<Integer> array, int i, int j) {
        int num = array.get(i);
        array.set(i, array.get(j));
        array.set(j,num);
    }
}

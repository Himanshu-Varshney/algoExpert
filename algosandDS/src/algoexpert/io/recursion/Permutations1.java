package algoexpert.io.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations1 {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permuations = new ArrayList<>();
        getPermutations(array,new ArrayList<Integer>(),permuations);
        return permuations;
    }

    private static void getPermutations(List<Integer> array, List<Integer> permutation, List<List<Integer>> permuations) {
        if(array.size()==0 && !permutation.isEmpty()){
            permuations.add(permutation);
        }else{
            for(int i=0;i<array.size();i++){
                List<Integer> newArray = new ArrayList<>(array);
                newArray.remove(i);
                List<Integer> newPermutation = new ArrayList<>(permutation);
                newPermutation.add(array.get(i));
                getPermutations(newArray,newPermutation,permuations);
     }
        }


    }
}

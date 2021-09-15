package algoexpert.io.recursion;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {

    public static int productSum(List<Object> array) {
        // Write your code here.
        return productSum(array,1);
    }


    public static int productSum(List<Object> array,int multiplier) {
       int sum=0;

       for(Object obj : array){
           if(obj instanceof ArrayList){
               sum+=productSum((ArrayList<Object>)obj,multiplier+1);
           }else{
               sum = sum+(Integer)obj;
           }
       }

        return sum*multiplier;
    }
}

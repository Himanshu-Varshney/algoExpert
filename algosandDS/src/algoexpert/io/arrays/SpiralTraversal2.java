package algoexpert.io.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal2 {

    public static List<Integer> spiralTraverse(int[][] array) {
        if(array.length==0) return new ArrayList<Integer>();
        List<Integer> outputArr = new ArrayList<>();
        spiralFill(array,0,array.length-1,0,array[0].length-1,outputArr);
        return outputArr;
    }

    public static void spiralFill(int[][] array,int startRow,int endRow,
            int startCol,int endCol,List<Integer> outputArr){
        if(startRow>endRow || startCol>endCol)
            return;

        //iterating top row left to right
        for(int col = startCol;col<=endCol;col++){
            outputArr.add(array[startRow][col]);
        }
        //iterate rightmost column top to bottom
        for(int row = startRow+1 ;row<=endRow;row++){
            outputArr.add(array[row][endCol]);
        }
        //iterate last row from right to left
        for(int col=endCol-1 ;col>=startCol;col--){
            //Handle the edge case when there is single row in the middle of matrix.
            //We do not want to double count this row, which we have already counted in
            //first for loop
            if(startRow ==endRow)break;
            outputArr.add(array[endRow][col]);
        }
        //iterate first column from bottom to top
        for(int row=endRow-1;row>startRow;row--){
            //Handle the edge case when there is single column in the middle of matrix.
            //We do not want to double count this column, which we have already counted in
            //second for loop
            if(startCol==endCol)break;
            outputArr.add(array[row][startCol]);
        }
        spiralFill(array,startRow+1,endRow-1,startCol+1,endCol-1,outputArr);

    }
}

package algoexpert.io.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal1 {

    public static List<Integer> spiralTraverse(int[][] array) {
            int startRow = 0;
            int endRow = array.length-1;
            int startCol = 0;
            int endCol = array[0].length-1;
            List<Integer> outputArr = new ArrayList<>();
            while(startRow<=endRow && startCol<=endCol){
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

                startRow++;
                endRow--;
                startCol++;
                endCol--;
            }


            return outputArr;
    }
}

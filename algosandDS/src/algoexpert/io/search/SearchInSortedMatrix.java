package algoexpert.io.search;

public class SearchInSortedMatrix {
  public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;

        while (row <matrix.length && col>=0){
            int num = matrix[row][col];
            if(num>target){
                col--;
            }else if(num <target){
                row++;
            }else{
                return new int[]{row,col};
            }
        }

        return new int[] {-1, -1};
    }
}

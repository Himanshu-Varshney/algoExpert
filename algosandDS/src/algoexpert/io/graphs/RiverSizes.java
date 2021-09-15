package algoexpert.io.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RiverSizes {

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(visited[i][j]) {
                    //ignore already visited nodes
                    continue;
                }
                traverseNode(i,j,matrix,visited,sizes);

            }
        }
        return sizes;
    }

    private static void traverseNode(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        int currentRiverSize=0;
        Stack<Integer[]> nodesToExplore = new Stack<>();
        //put the current node in stack
        nodesToExplore.push(new Integer[]{i,j});

        while (!nodesToExplore.isEmpty()){
            Integer[] currentNode =nodesToExplore.pop();
            i = currentNode[0];
            j=currentNode[1];
            if(visited[i][j]){
                continue;
            }
            //if not visited first mark it as visited
            visited[i][j]=true;
            //if value at i,j is 0 ignore
            if (matrix[i][j]==0){
                continue;
            }
            //now value at i, j should be 1 , so increment the size counter since
            // it is river
            currentRiverSize++;
            //get the neighbors for node at i,j
            List<Integer[]> unvisitedNeighbors = getUnvisitedNeighbors(i,j,matrix,visited);
            for(Integer[] unvisitedNeighbor : unvisitedNeighbors){
                //push every unvited neighbor to stack
                nodesToExplore.push(unvisitedNeighbor);
            }
        }
        if(currentRiverSize>0){
            sizes.add(currentRiverSize);
        }

    }

    private static List<Integer[]> getUnvisitedNeighbors(int i, int j, int[][] matrix, boolean[][] visited) {
        List<Integer[]> unvisitedNeighbors = new ArrayList<>();

        // if it is not a top row and element above it is not visited ( for top row)
        if(i>0 && !visited[i-1][j]){
            unvisitedNeighbors.add(new Integer[]{i-1,j});
        }
        //if i is not last row and element above it is not visited (for bottom row)
        if(i<matrix.length-1 && !visited[i+1][j]){
            unvisitedNeighbors.add(new Integer[]{i+1,j});
        }
        //if j is not first column and element left to it is not visted (for first column)
        if(j>0 && !visited[i][j-1]){
            unvisitedNeighbors.add(new Integer[]{i,j-1});
        }
        //if j is not last column and element right to it is not visted (for last column)
        if(j< matrix[0].length-1 && !visited[i][j+1]){
            unvisitedNeighbors.add(new Integer[]{i,j+1});
        }
        return unvisitedNeighbors;
    }
}

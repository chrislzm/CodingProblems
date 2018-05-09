package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem_417_Pacific_Atlantic_Water_Flow {
    private static final int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<int[]>();
        if(matrix == null || matrix.length == 0) return result;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] flowToPacific = new boolean[rows][cols];
        boolean[][] flowToAtlantic = new boolean[rows][cols];
        searchFrom(0,0,rows,cols,matrix,flowToPacific);
        searchFrom(rows-1,cols-1,rows,cols,matrix,flowToAtlantic);
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(flowToPacific[i][j] && flowToAtlantic[i][j]) {
                    result.add(new int[]{i,j});
                }
            }
        }
        return result;
    }
    
    private void searchFrom(int startRow, int startCol, int rows, int cols, int[][] matrix, boolean[][] flowsTo) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i=0; i<rows; i++) {
            search(i,startCol,startRow,startCol,0,matrix,flowsTo,visited);
        }
        for(int j=0; j<cols; j++) {
            search(startRow,j,startRow,startCol,0,matrix,flowsTo,visited);
        }
    }
    
    private void search(int i, int j, int startRow, int startCol, int prev, int[][] matrix, boolean[][] flowsTo, boolean[][] visited) {
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || visited[i][j] || flowsTo[i][j]) return;
        if(i==startRow || j==startCol || matrix[i][j] >= prev) {
            visited[i][j] = true;
            flowsTo[i][j] = true;
            for(int[] direction : DIRECTIONS) {
                search(i+direction[0],j+direction[1],startRow,startCol,matrix[i][j],matrix,flowsTo,visited);
            }
            visited[i][j] = false;
        }
    }
}

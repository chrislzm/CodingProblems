package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem_417_Pacific_Atlantic_Water_Flow_v2 {
    
    private static final int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<int[]>();
        if(matrix == null || matrix.length == 0) return result;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] flowToPacific = new boolean[rows][cols];
        boolean[][] flowToAtlantic = new boolean[rows][cols];
        for(int i=0; i<rows; i++) {
            search(i,0,Integer.MIN_VALUE,matrix,flowToPacific);
            search(i,cols-1,Integer.MIN_VALUE,matrix,flowToAtlantic);
        }
        for(int j=0; j<cols; j++) {
            search(0,j,Integer.MIN_VALUE,matrix,flowToPacific);
            search(rows-1,j,Integer.MIN_VALUE,matrix,flowToAtlantic);
        }
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(flowToPacific[i][j] && flowToAtlantic[i][j]) {
                    result.add(new int[]{i,j});
                }
            }
        }
        return result;
    }
    
    private void search(int i, int j, int prev, int[][] matrix, boolean[][] flowsTo) {
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || flowsTo[i][j] || matrix[i][j] < prev) return;
        flowsTo[i][j] = true;
        for(int[] direction : DIRECTIONS) {
            search(i+direction[0],j+direction[1],matrix[i][j],matrix,flowsTo);
        }
    }
}

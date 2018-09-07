package com.chrisleung.leetcode.solutions;

public class Problem_695_Max_Area_of_Island {
    
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int max = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                max = Math.max(max,getIslandSize(grid,i,j));
            }
        }
        return max;
    }
    
    private static int[][] DIRECTIONS = {{0,1},{0,-1},{1,0},{-1,0}};
    
    private int getIslandSize(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] < 1) return 0;
        grid[i][j] = 0;
        int islandSize = 1;
        for(int[] direction : DIRECTIONS) {
            islandSize += getIslandSize(grid,i+direction[0],j+direction[1]);
        }
        return islandSize;
    }
    
}

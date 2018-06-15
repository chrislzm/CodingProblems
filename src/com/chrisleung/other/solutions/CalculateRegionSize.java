package com.chrisleung.other.solutions;

//Amazon technical phone screen question #1
public class CalculateRegionSize {
  //=========================
  int[][] matrix = {{1,0,1,0},
                    {1,1,0,0},
                    {1,0,1,1}};
  int[][] DIRECTIONS = {{-1,0},{1,0},{0,1},{0,-1}};
  int VISITED = -1;

  // Return 4          
  int getLargestRegionSize(int[][] matrix) {
      // Input validation
      if(matrix == null || matrix.length == 0) return 0;
      int height = matrix.length;
      int width = matrix[0].length;
      int maxRegionSize = 0;
      for(int i=0; i<height; i++) {
          for(int j=0; j<width; j++) {
              maxRegionSize = Math.max(maxRegionSize,helper(matrix,i,j,height,width));
          }
      }
      for(int i=0; i<height; i++) {
          for(int j=0; j<width; j++) {
              if(matrix[i][j] == VISITED) 
                  matrix[i][j] = 1;
          }
      }
      return maxRegionSize;
  }

  int helper(int[][] matrix, int i, int j, int height, int width) {
      if(i < 0 || j > 0 || i >= height || j >= width || matrix[i][j] == 0 || matrix[i][j] == VISITED) {
          return 0;
      }
      // Else we have land
      matrix[i][j] = VISITED;
      int islandSize = 1;
      for(int[] direction : DIRECTIONS) {
          islandSize += helper(matrix,i+direction[0],j+direction[1],height,width);
      }
      return islandSize;
  }




}

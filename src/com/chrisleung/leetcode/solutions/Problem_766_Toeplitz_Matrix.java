package com.chrisleung.leetcode.solutions;

public class Problem_766_Toeplitz_Matrix {
    
    public boolean isToeplitzMatrix(int[][] matrix) {
        // Columns first starting with 0
        for(int j=0; j<matrix[0].length-1; j++) {
            // Go through every row and column
            for(int i=0; i+1<matrix.length && i+j+1 < matrix[0].length; i++) {
                if(matrix[i][j+i] != matrix[i+1][j+i+1]) return false;
            }
        }
        
        // Rows starting with 1
        for(int i=1; i<matrix.length-1; i++) {
            // Go through every row and column
            for(int j=0; i+j+1<matrix.length && j+1< matrix[0].length; j++) {
                if(matrix[i+j][j] != matrix[i+j+1][j+1]) return false;
            }
        }
        return true;
    }
}

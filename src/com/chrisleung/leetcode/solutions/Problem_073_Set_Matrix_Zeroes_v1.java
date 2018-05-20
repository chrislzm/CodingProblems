package com.chrisleung.leetcode.solutions;

public class Problem_073_Set_Matrix_Zeroes_v1 {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        boolean firstRowZeroed = false;
        boolean firstColZeroed = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Check first col of each row for zeroes
        for(int[] row : matrix) {
            if(row[0] == 0) {
                firstColZeroed = true;
                break;
            }
        }
        // Check each col of first row
        for(int col : matrix[0]) {
            if(col == 0) {
                firstRowZeroed = true;
                break;
            }
        }
        // Use first row and col to mark rows and cols to zero out
        for(int i = 1; i < rows; i++) {
            for(int j= 1; j < cols; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // Zero out the rows
        for(int i=1; i<rows; i++) {
            if(matrix[i][0] == 0) {
                for(int j=1; j<cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // Zero out the cols
        for(int j=1; j<cols; j++) {
            if(matrix[0][j] == 0) {
                for(int i=1; i<rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstColZeroed) {
            for(int i=0; i<rows; i++) {
                matrix[i][0] = 0;
            }
        }
        if(firstRowZeroed) {
            for(int j=0; j<cols; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}

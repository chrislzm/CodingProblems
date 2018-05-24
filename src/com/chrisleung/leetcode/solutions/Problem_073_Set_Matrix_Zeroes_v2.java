package com.chrisleung.leetcode.solutions;

/**
 * Same thing, shorter code.
 * @author Chris Leung
 */
public class Problem_073_Set_Matrix_Zeroes_v2 {
    
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        boolean clearFirstCol = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0; i<rows; i++) {
            if(matrix[i][0] == 0) {
                clearFirstCol = true;
            }
            for(int j=1; j<cols; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=rows-1; i>=0; i--) {
            for(int j=cols-1; j>0; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if(clearFirstCol) {
                matrix[i][0] = 0;
            }
        }
    }
    
}

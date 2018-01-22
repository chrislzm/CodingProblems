/*
 * Much more concise solution. :-) By transitivity, just compare each row with the next row.
 */
package com.chrisleung.leetcode.solutions;

public class Problem_766_Toeplitz_Matrix_v2 {
    
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length-1; i++)
            for(int j=0; j<matrix[0].length-1; j++)
                if(matrix[i][j] != matrix[i+1][j+1]) return false;
        return true;
    }
}

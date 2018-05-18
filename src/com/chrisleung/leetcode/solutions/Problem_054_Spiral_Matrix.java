package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem_054_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return output;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int layer = 0; 2*layer < rows && 2*layer < cols; layer++) {
            // First row
            int i=layer,j=layer;
            for(;j<cols-1-layer; j++) {
                output.add(matrix[i][j]);
            }
            // Last entire column
            j=cols-layer-1;
            for(i=layer; i<rows-layer; i++) {
                output.add(matrix[i][j]);
            }
            // Bottom row, if any
            i = rows-1-layer;
            if(i != layer) {
                for(j=cols-2-layer; j>=layer; j--) {
                    output.add(matrix[i][j]);
                }
            }
            // Left column, if any
            j = layer;
            if(j != cols-1-layer) {
                for(i=rows-2-layer; i>layer; i--) {
                    output.add(matrix[i][j]);
                }
            }
        }
        return output;
    }
}

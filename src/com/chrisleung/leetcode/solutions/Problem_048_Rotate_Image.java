package com.chrisleung.leetcode.solutions;

public class Problem_048_Rotate_Image {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        int n = matrix.length;
        for(int layer=0; layer<n/2; layer++) {
            for(int x=layer; x<n-layer-1; x++) {
                int tmp = matrix[layer][x];
                matrix[layer][x]=matrix[n-1-x][layer];
                matrix[n-1-x][layer]=matrix[n-1-layer][n-1-x];
                matrix[n-1-layer][n-1-x]=matrix[x][n-1-layer];
                matrix[x][n-1-layer]=tmp;
            }
        }
    }
}

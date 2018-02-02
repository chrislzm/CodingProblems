package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem_054_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return l;
        int colStart = 0, colEnd = matrix[0].length-1, rowStart = 0, rowEnd = matrix.length-1;
        while(colStart <= colEnd && rowStart <= rowEnd) {
            for(int j=colStart; j <= colEnd; j++) {
                l.add(matrix[rowStart][j]);
            }
            rowStart++;
            for(int i=rowStart; i <= rowEnd; i++) {
                l.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(rowStart <= rowEnd) {
                for(int j=colEnd; j >= colStart; j--) {
                    l.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }
            if(colStart <= colEnd) {
                for(int i=rowEnd; i >= rowStart; i--) {
                    l.add(matrix[i][colStart]);
                }          
                colStart++;
            }
        }
        return l;
    }
}

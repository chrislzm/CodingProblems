package com.chrisleung.leetcode.solutions;

public class Problem_085_Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length ==0) return 0;
        int[] columnTotal = new int[matrix[0].length]; // Stores total 1's found in column
        int overallMax = 0;
        for(char[] row : matrix) { // Go through each row of matrix
            for(int i=0; i<row.length; i++) { // Update the column total
                if(row[i] == '1')
                    columnTotal[i]++;
                else
                    columnTotal[i] = 0;
            }
            for(int i=0; i<columnTotal.length; i++) { // Now update the max value
                overallMax = Math.max(overallMax,columnTotal[i]); // Check for long column-wise rectangle
                int rowTotal = columnTotal[i]; // Now check for row-wise rectangles
                for(int j=i-1; j>=0; j--) { // Add values to left
                    if(columnTotal[j] >= columnTotal[i])
                        rowTotal += columnTotal[i];
                    else
                        break;
                }
                for(int j=i+1; j<columnTotal.length; j++) { // Add values to right
                    if(columnTotal[j] >= columnTotal[i])
                        rowTotal += columnTotal[i];
                    else
                        break;
                }
                overallMax = Math.max(overallMax,rowTotal);
            }
        }
        return overallMax;
    }
}

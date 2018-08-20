package com.chrisleung.other.solutions;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

public class SpiralMatrix {
    
    static int[][] generateSpiralMatrix(int n) {
        if(n < 0) return new int[0][0];
        int[][] output = new int[n][n];
        int cur = 1;
        int max = n*n;
        int layer = 0;
        while(cur <= max) {
            // Top
            if(cur==max) {
                output[layer][layer] = cur;
                break;
            }
            for(int i=layer, j=layer; j<n-layer-1; j++) {
                output[i][j] = cur++;
            }
            // Right
            for(int i=layer, j=n-layer-1; i<n-layer-1; i++) {
                output[i][j] = cur++;
            }
            // Bottom
            for(int i=n-layer-1, j=n-layer-1; j>layer; j--) {
                output[i][j] = cur++;
            }
            // Left
            for(int i=n-layer-1, j=layer; i>layer; i--) {
                output[i][j] = cur++;
            }
            layer++;
        }
        return output;
    }
    
    static void printMatrix(int[][] m) {
        System.out.println(String.format("Printing %s x %s matrix: ",m.length,m.length));
        for(int i=0; i<m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }
    
    static void testThreebyThree() {
        int[][] expectedResult = {{1,2,3},{8,9,4},{7,6,5}};
        int[][] actualResult = generateSpiralMatrix(3);
        try {
            assertTrue(Arrays.deepEquals(expectedResult,actualResult));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    static void testThreebyThreeError() {
        int[][] expectedResult = {{0,2,3},{8,9,4},{7,6,5}};
        int[][] actualResult = generateSpiralMatrix(3);
        try {
            assertTrue(Arrays.deepEquals(expectedResult,actualResult));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[] ) throws Exception {
        /*
        printMatrix(generateSpiralMatrix(0));
        printMatrix(generateSpiralMatrix(1));
        printMatrix(generateSpiralMatrix(2));
        printMatrix(generateSpiralMatrix(3));
        printMatrix(generateSpiralMatrix(4));
        printMatrix(generateSpiralMatrix(5));
        */
        testThreebyThree();
        testThreebyThreeError();
    }
}
package com.chrisleung.other.solutions;

import java.util.Arrays;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int[][] tests = {{},
                {1},
                {1,1,1},
                {0,1,2},
                {-1,-2,-3},
                {1,2},
                {-1,2,-3}};

        for(int[] test : tests) {
            System.out.println(Arrays.toString(productExceptSelf(test)));
        }
    }
    
    static int[] productExceptSelf(int[] input) {
        if(input == null || input.length == 0) return new int[0];
        int[] output = new int[input.length];
        for(int i=0,product=1; i<input.length; i++) {
            output[i] = product;
            product *= input[i];
        }
        for(int i=input.length-1,product=1; i>=0; i--) {
            output[i] *= product;
            product *= input[i];
        }
        return output;
    }
}

package com.chrisleung.leetcode.solutions;

import java.util.Arrays;

/* Approach 1: Just scan the temperature array and get the minimum index */
public class Problem_739_Daily_Temperatures_v1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] tempIndex = new int[101]; // temperature - index map
        int[] output = new int[temperatures.length];
        Arrays.fill(tempIndex,-1);
        for(int i=temperatures.length-1; i>=0; i--) {
            tempIndex[temperatures[i]] = i;
            output[i] = 0;
            if(i+1 < temperatures.length && temperatures[i+1] > temperatures[i]) {
                output[i] = 1;
            } else {
                int minIndex = Integer.MAX_VALUE;
                for(int j = temperatures[i]+1; j<=100; j++) {
                    if(tempIndex[j] != -1) {
                        minIndex = Math.min(minIndex,tempIndex[j]);
                    }
                }
                output[i] = minIndex == Integer.MAX_VALUE ? 0 : minIndex - i;
            }
        }
        return output;
    }
}

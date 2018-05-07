package com.chrisleung.leetcode.solutions;

import java.util.Arrays;

public class Problem_062_Unique_Paths {
    public int uniquePaths(int m, int n) {
        int[] ways = new int[n];
        Arrays.fill(ways,1);
        for(int i=m-2; i >= 0; i--) {
            for(int j=n-2; j >= 0; j--) {
                ways[j] += ways[j+1];
            }
        }
        return ways[0];
    }
}

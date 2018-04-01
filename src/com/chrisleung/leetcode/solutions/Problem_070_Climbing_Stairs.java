package com.chrisleung.leetcode.solutions;

public class Problem_070_Climbing_Stairs {
    public int climbStairs(int n) {
        if(n < 0) return 0;
        if(n < 2) return 1;
        int a = 1;
        int b = 1;
        int totalWays = 0;
        for(int i=2; i<=n; i++) {
            totalWays = a+b;
            a = b;
            b = totalWays;
        }
        return totalWays;
    }
}

package com.chrisleung.leetcode.solutions;

public class Problem_069_Sqrt_X {
    public int mySqrt(int x) {
        int prev = 0;
        int cur = 1;
        while((long)cur*cur <= x) {
            prev = cur;
            cur++;
        }
        return prev;
    }
}

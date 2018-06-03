package com.chrisleung.leetcode.solutions;

public class Problem_326_Power_of_Three {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        return (1162261467 % n) == 0;
    }
}

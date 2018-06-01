package com.chrisleung.leetcode.solutions;

public class Problem_231_Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return (n & (n-1)) == 0;
    }
}

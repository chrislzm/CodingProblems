package com.chrisleung.leetcode.solutions;

public class Problem_198_House_Robber_I {
    
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int prev = 0;
        int prevprev = 0;
        for(int n : nums) {
            int cur = prev > n+prevprev ? prev : n+prevprev;
            prevprev = prev;
            prev = cur;
        }
        return prev;
    }
    
}

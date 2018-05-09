package com.chrisleung.leetcode.solutions;

public class Problem_213_House_Robber_II {
    
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums,0,nums.length-1),rob(nums,1,nums.length));
    }
    
    private int rob(int[] nums, int start, int end) {
        int prev = 0;
        int prevprev = 0;
        for(int i=start; i<end; i++) {
            int cur = Math.max(prev,prevprev+nums[i]);
            prevprev = prev;
            prev = cur;
        }
        return prev;
    }
    
}

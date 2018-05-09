package com.chrisleung.leetcode.solutions;

public class Problem_377_Combination_Sum_IV_Recursive {
    public int combinationSum4(int[] nums, int target) {
        return numWays(nums,target,new Integer[target+1]);
    }
    
    private int numWays(int[] nums, int remaining, Integer[] memo) {
        if(remaining < 0) return 0;
        if(remaining == 0) return 1;
        if(memo[remaining] == null) {
            int ways = 0;
            for(int n : nums) {
                ways += numWays(nums,remaining-n,memo);
            }
            memo[remaining] = ways;
        }
        return memo[remaining];
    }
}

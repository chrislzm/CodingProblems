package com.chrisleung.leetcode.solutions;

public class Problem_300_Longest_Increasing_Subsequence_Memoization {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Integer[][] memo = new Integer[nums.length+1][nums.length];
        return lengthOfLISHelper(nums,nums.length,nums.length-1,memo);
    }
    private int lengthOfLISHelper(int[] nums, int prevIndex, int curIndex, Integer[][] memo) {
        if(curIndex < 0) return 0;
        if(memo[prevIndex][curIndex] == null) {
            int maxExcludeCur = lengthOfLISHelper(nums,prevIndex,curIndex-1,memo);
            int maxIncludeCur = 0;
            if(prevIndex == nums.length || nums[prevIndex] > nums[curIndex]) {
                maxIncludeCur = 1 + lengthOfLISHelper(nums,curIndex,curIndex-1,memo);
            }
            memo[prevIndex][curIndex] = Math.max(maxExcludeCur,maxIncludeCur);
        }
        return memo[prevIndex][curIndex];
    }
}

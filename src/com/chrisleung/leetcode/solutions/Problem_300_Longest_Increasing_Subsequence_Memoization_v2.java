package com.chrisleung.leetcode.solutions;

public class Problem_300_Longest_Increasing_Subsequence_Memoization_v2 {

    int lengthOfLIS(int[] nums) {
        int numElements = nums.length;
        Integer[][] memo = new Integer[numElements+1][numElements+1];
        return lengthOfLISHelper(0,1, nums, numElements,memo);
    }

    int lengthOfLISHelper(int prev, int cur, int[] nums, int numElements, Integer[][] memo) {
        if(cur > numElements) return 0;
        if(memo[prev][cur] == null) {
            int longestExclude = lengthOfLISHelper(prev,cur+1,nums,numElements,memo);
            int longestInclude = 0;
            if(prev == 0 || nums[cur-1] > nums[prev-1]) {
                longestInclude = 1 + lengthOfLISHelper(cur,cur+1,nums,numElements,memo);
            }
            memo[prev][cur] = Math.max(longestExclude,longestInclude);
        }
        return memo[prev][cur];
    }
}

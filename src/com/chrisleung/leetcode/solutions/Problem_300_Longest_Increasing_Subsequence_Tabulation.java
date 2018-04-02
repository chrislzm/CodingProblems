package com.chrisleung.leetcode.solutions;


public class Problem_300_Longest_Increasing_Subsequence_Tabulation {
    int lengthOfLIS(int[] nums) {
        int numElements = nums.length;
        int[][] table = new int[numElements+1][numElements+2];
        for(int cur=numElements; cur > 0; cur--) {
            for(int prev=cur-1; prev >= 0; prev--) {
                int longestExclude = table[prev][cur+1];
                int longestInclude = 0;
                if(prev == 0 || nums[cur-1] > nums[prev-1]) {
                    longestInclude = 1 + table[cur][cur+1];
                }
                table[prev][cur] = Math.max(longestExclude,longestInclude);
            }
        }
        return table[0][1];
    }
}

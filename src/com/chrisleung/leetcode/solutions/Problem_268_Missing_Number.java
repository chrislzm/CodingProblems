package com.chrisleung.leetcode.solutions;

public class Problem_268_Missing_Number {
    public int missingNumber(int[] nums) {
        int missing = nums.length+1; // Since we won't be iterating through this number
        for(int i=0; i<nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}

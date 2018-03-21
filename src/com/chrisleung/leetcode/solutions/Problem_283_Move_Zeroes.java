package com.chrisleung.leetcode.solutions;

public class Problem_283_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2) return;
        boolean didSwap = true;
        while(didSwap) {
            didSwap = false;
            for(int i=nums.length-2; i>=0; i--) {
                if(nums[i] == 0 && nums[i+1] != 0) {
                    nums[i] = nums[i+1];
                    nums[i+1] = 0;
                    didSwap = true;
                }
            }
        }
    }
}

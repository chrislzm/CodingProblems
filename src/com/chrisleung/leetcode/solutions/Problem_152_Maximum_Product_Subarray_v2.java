package com.chrisleung.leetcode.solutions;

public class Problem_152_Maximum_Product_Subarray_v2 {
    public int maxProduct(int[] nums) {
        int currentMin = nums[0];
        int currentMax = nums[0];
        int overallMax = nums[0];
        for(int i=1; i< nums.length; i++) {
            if(nums[i] < 0) { // Swap values
                int tmp = currentMax;
                currentMax = currentMin;
                currentMin = tmp;
            }
            currentMax = Math.max(nums[i],currentMax*nums[i]);
            currentMin = Math.min(nums[i],currentMin*nums[i]);
            overallMax = Math.max(overallMax, currentMax);
        }
        return overallMax;
    }
}

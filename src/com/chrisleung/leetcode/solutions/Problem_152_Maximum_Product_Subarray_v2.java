package com.chrisleung.leetcode.solutions;

public class Problem_152_Maximum_Product_Subarray_v2 {
    public int maxProduct(int[] nums) {
        int minToThisPoint = nums[0];
        int maxToThisPoint = nums[0];
        int overallMax = nums[0];
        for(int i=1; i< nums.length; i++) {
            if(nums[i] < 0) {
                int tmp = maxToThisPoint;
                maxToThisPoint = minToThisPoint;
                minToThisPoint = tmp;
            }
            maxToThisPoint = Math.max(nums[i],maxToThisPoint*nums[i]);
            minToThisPoint = Math.min(nums[i],minToThisPoint*nums[i]);
            overallMax = Math.max(overallMax, maxToThisPoint);
        }
        return overallMax;
    }
}

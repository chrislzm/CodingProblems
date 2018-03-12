package com.chrisleung.leetcode.solutions;

public class Problem_152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int currProduct1 = nums[0];
        int currProduct2 = 0;
        int max = nums[0];
        for(int i=1; i < nums.length; i++) {
            if(currProduct1 == 0) {
                currProduct1 = nums[i];
            } else {
                currProduct1 *= nums[i];
            }
            if(currProduct2 == 0) {
                if(nums[i-1] < 0) {
                    currProduct2 = nums[i];
                }
            } else {
                currProduct2 *= nums[i];
            }
            max = Math.max(currProduct1,max);
            if(currProduct2 != 0) {
                max = Math.max(currProduct2, max);
            }
        }
        return max;
    }
}

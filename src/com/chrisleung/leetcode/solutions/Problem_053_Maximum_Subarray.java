package com.chrisleung.leetcode.solutions;

public class Problem_053_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for(int n : nums) {
            if(n > max && cur <= 0) {
                max = n;
                cur = n;
            } else if(n > cur && cur < 0) {
                cur = n;
            } else {
                cur += n;
                max = Math.max(cur,max);
            }
        }
        return max;
    }
}

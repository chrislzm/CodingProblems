package com.chrisleung.leetcode.solutions;

/**
 * O(n) version
 * @author Chris Leung
 */
public class Problem_283_Move_Zeroes_v2 {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int copyIndex = -1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0 && copyIndex < 0) {
                copyIndex = i;
            } else if(nums[i]!=0 && copyIndex >= 0) {
                nums[copyIndex] = nums[i];
                nums[i]=0;
                copyIndex++;
            }
        }
    }
}

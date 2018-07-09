package com.chrisleung.leetcode.solutions;

public class Problem_026_Remove_Duplicates_From_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int prev = nums[0];
        int copyIndex = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != prev) {
                nums[copyIndex++] = nums[i];
                prev = nums[i];
            }
        }
        return copyIndex;
    }
}

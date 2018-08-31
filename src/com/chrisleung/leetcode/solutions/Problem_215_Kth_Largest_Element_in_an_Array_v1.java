package com.chrisleung.leetcode.solutions;

import java.util.Arrays;

/**
 * O(n log n) solution
 * @author Chris Leung
 *
 */
public class Problem_215_Kth_Largest_Element_in_an_Array_v1 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

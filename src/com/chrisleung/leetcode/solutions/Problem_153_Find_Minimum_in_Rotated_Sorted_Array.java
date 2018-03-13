package com.chrisleung.leetcode.solutions;

public class Problem_153_Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low < high) {
            if(nums[low] < nums[high]) return nums[low];
            int mid = (low+high)/2;
            if(nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return nums[low];
    }
}

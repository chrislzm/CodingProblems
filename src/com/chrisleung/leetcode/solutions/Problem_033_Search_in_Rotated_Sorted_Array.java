package com.chrisleung.leetcode.solutions;

public class Problem_033_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length ==0) return -1;
        int lo = 0, hi=nums.length-1;
        while(lo <= hi) {
            int mid = (lo+hi) >>> 1;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[lo] <= nums[mid]) {
                if(target >= nums[lo] && target < nums[mid]) {
                    hi = mid-1;
                } else {
                    lo = mid+1;
                }
            } else { // Right side is ordered
                if(target > nums[mid] && target <= nums[hi]) {
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            }
        }
        return -1;
    }
}

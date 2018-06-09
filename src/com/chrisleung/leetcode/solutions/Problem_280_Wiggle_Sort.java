package com.chrisleung.leetcode.solutions;

public class Problem_280_Wiggle_Sort {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        boolean lower = true;
        for(int cur = 0; cur < nums.length-1; cur++) {
            int next = cur+1;
            if(lower) {
                if(nums[cur] > nums[next]) {
                    swap(cur,next,nums);
                }
            } else {
                if(nums[cur] < nums[next]) {
                    swap(cur,next,nums);
                }
            }
            lower = !lower;
        }
    }
    
    private void swap(int index1, int index2, int[] arr) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}

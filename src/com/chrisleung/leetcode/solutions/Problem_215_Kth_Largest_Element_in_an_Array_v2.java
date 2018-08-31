package com.chrisleung.leetcode.solutions;

/**
 * O(n) best case, O(n^2) worst case solution using partition method (of quicksort)
 * @author Chris Leung
 *
 */
public class Problem_215_Kth_Largest_Element_in_an_Array_v2 {

    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length-1;
        int target = high-(k-1);
        while(true) {
            int partitionIndex = partition(nums,low,high);
            if(partitionIndex < target) {
                low = partitionIndex+1;
            } else if(partitionIndex > target) {
                high = partitionIndex-1;
            } else {
                break;
            }
        }
        return nums[target];
    }
    
    private int partition(int[] nums, int low, int high) {
        int pivotIndex = low;
        low++;
        int pivot = nums[pivotIndex];
        while(low <= high) {
            if(nums[low] < pivot) {
                low++;  
            } else if(nums[high] >= pivot) {
                high--;
            } else {
                swap(nums,low,high);
            }                
        }
        swap(nums,pivotIndex,high);
        return high;
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

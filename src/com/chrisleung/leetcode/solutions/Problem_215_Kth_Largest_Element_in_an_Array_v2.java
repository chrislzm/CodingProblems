package com.chrisleung.leetcode.solutions;

/**
 * O(n) best case, O(n^2) worst case solution using partition method (of quicksort)
 * @author Chris Leung
 *
 */
public class Problem_215_Kth_Largest_Element_in_an_Array_v2 {

    public int findKthLargest(int[] nums, int k) {
        int loIndex = 0;
        int hiIndex = nums.length-1;
        int targetIndex = nums.length-k;
        while(true) {
            int partitionIndex = partition(nums,loIndex,hiIndex);
            if(partitionIndex < targetIndex) {
                loIndex = partitionIndex+1;
            } else if(partitionIndex > targetIndex) {
                hiIndex = partitionIndex-1;
            } else { // partitionIndex == targetIndex
                break;
            }
        }
        return nums[targetIndex];
    }
    
    private int partition(int[] nums, int loIndex, int hiIndex) {
        int pivotIndex = loIndex;
        loIndex++;
        int pivot = nums[pivotIndex];
        while(loIndex <= hiIndex) {
            if(nums[loIndex] < pivot) {
                loIndex++;  
            } else if(nums[hiIndex] >= pivot) {
                hiIndex--;
            } else {
                swap(nums,loIndex,hiIndex);
            }                
        }
        swap(nums,pivotIndex,hiIndex);
        return hiIndex;
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

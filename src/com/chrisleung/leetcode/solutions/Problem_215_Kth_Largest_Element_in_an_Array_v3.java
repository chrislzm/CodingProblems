package com.chrisleung.leetcode.solutions;

import java.util.Random;

/**
 * O(n) average case solution using partition method (of quicksort) and shuffle to randomize elements
 * @author Chris Leung
 *
 */
public class Problem_215_Kth_Largest_Element_in_an_Array_v3 {

    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
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
    
    /** 
     * Quicksort partition method - handles two edge cases:
     * 1) loIndex == hiIndex (bypasses the while-loop entirely and just returns the same index)
     * 2) loIndex = hiIndex-1
     *   2a) pivotValue < nums[hiIndex] (in this case, hiIndex will be decremented below loIndex, then the while-loop breaks)
     *   2b) pivotValue > nums[hiIndex] (in this case, loIndex will be incremented above hiIndex, then the while-loop breaks) 
     */
    private int partition(int[] nums, int loIndex, int hiIndex) {
        int pivotValue = nums[loIndex];
        int pivotIndex = loIndex;
        loIndex++;
        // Make all elements to the right of hiIndex greater than the pivotValue
        while(loIndex <= hiIndex) { 
            if(nums[loIndex] < pivotValue) {
                loIndex++;  
            } else if(nums[hiIndex] >= pivotValue) {
                hiIndex--;
            } else {
                swap(nums,loIndex,hiIndex);
            }                
        }
        // All elements to the right of hiIndex are now greater than pivotValue
        swap(nums,pivotIndex,hiIndex); 
        return hiIndex;
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    private void shuffle(int[] arr) {
        Random r = new Random();
        int range = arr.length;
        for(int i=0; i<range; i++) {
            int swapIndex = r.nextInt(range);
            swap(arr,i,swapIndex);
        }
    }
}

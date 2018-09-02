package com.chrisleung.other.solutions;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    
    static public void quicksort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        shuffle(nums);
        quicksort(nums,0,nums.length-1);
    }
        
    static private void quicksort(int[] nums, int loIndex, int hiIndex) {
        if(loIndex >= hiIndex) return;
        int partitionIndex = partition(nums, loIndex, hiIndex);
        quicksort(nums,loIndex,partitionIndex-1);
        quicksort(nums,partitionIndex+1,hiIndex);
    }
    
    static private int partition(int[] nums, int loIndex, int hiIndex) {
        int pivotValue = nums[loIndex];
        int pivotIndex = loIndex;
        loIndex++;
        while(loIndex <= hiIndex) { // Make all elements to the right of hiIndex > pivotValue  
            if(nums[loIndex] < pivotValue) {
                loIndex++;  
            } else if(nums[hiIndex] >= pivotValue) {
                hiIndex--;
            } else {
                swap(nums,loIndex,hiIndex);
            }                
        }
        swap(nums,pivotIndex,hiIndex);
        return hiIndex;
    }
    
    static private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    static private void shuffle(int[] arr) {
        Random r = new Random();
        int range = arr.length;
        for(int i=0; i<range; i++) {
            int swapIndex = r.nextInt(range);
            swap(arr,i,swapIndex);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {505159159,1,656,21,-15959,5,2,1,2,5,3,9,0};
        quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

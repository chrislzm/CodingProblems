package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * We can get O(1) by taking advantage of the fact that there are no duplicates in the array. If the difference in value between two array elements is equal to the difference in their indexes, then we immediately know that it's a range and there's no need to iterate through it.
 * 
 * Example: If we have an array with 1 billion elements, and arr[0] is 1 and arr[999999999] is 1000000000 (1 billion), then we immediately know that the range is "1->1000000000" and there's no need to check the elements in between. Instead of O(n) time our best case is now O(1) time.
 * 
 * We can apply this recursively using a "binary search" inspired algorithm. Best case O(1) time and space (when the entire array is a range), worst case O(n) time and space (when there are no ranges).
 * 
 * @author Chris Leung
 *
 */
public class Problem_228_Summary_Ranges {
    
    public List<String> summaryRanges(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<String>();
        List<int[]> ranges = new LinkedList<>();
        binaryRangeDetect(nums,0,nums.length-1,ranges);
        combineRanges(ranges);
        return convertToString(ranges);
    }
    
    private void binaryRangeDetect(int[] arr, int low, int high, List<int[]> ranges) {
        int mid = (low+high)/2;
        rangeDetect(arr,low,mid,ranges);
        rangeDetect(arr,mid,high,ranges);
    }
    
    private void rangeDetect(int[] arr, int low, int high, List<int[]> ranges) {
        int diff = high-low;
        if(diff >= 2) {
            if(diff == arr[high] - arr[low]) {
                ranges.add(new int[] {arr[low],arr[high]});
            } else {
                binaryRangeDetect(arr,low,high,ranges);
            }
        } else if(diff == 1) {
            if(arr[high] == arr[low]+1) {
                ranges.add(new int[]{arr[low],arr[high]});
            } else {
                ranges.add(new int[]{arr[low],arr[low]});
                ranges.add(new int[]{arr[high],arr[high]});
            }
        } else {
            ranges.add(new int[]{arr[low],arr[low]});
        }
    }
    
    /* Combine adjacent or overlapping ranges */
    private void combineRanges(List<int[]> ranges) {
        Iterator<int[]> it = ranges.iterator();
        int[] prev = it.next();
        while(it.hasNext()) {
            int[] cur = it.next();
            if(prev[1] == cur[0] || prev[1] == (cur[0]-1)) {
                prev[1] = cur[1];
                it.remove();
            } else {
                prev = cur;
            }
        }
    }
    
    private List<String> convertToString(List<int[]> ranges) {
        List<String> output = new ArrayList<>();
        for(int[] r : ranges) {
            if(r[0] == r[1]) {
                output.add(String.valueOf(r[0]));
            } else {
                output.add(r[0] + "->" + r[1]);
            }
        }
        return output;
    }
}

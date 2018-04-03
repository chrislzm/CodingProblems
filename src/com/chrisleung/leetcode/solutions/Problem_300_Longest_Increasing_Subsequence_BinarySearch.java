package com.chrisleung.leetcode.solutions;

import java.util.Arrays;

/**
 * O(n log n) solution
 * @author Chris Leung
 *
 */
public class Problem_300_Longest_Increasing_Subsequence_BinarySearch {
    
    // This method will always find the length of the Longest Increasing Subsequence
    public int lengthOfLIS(int[] nums) {
        int[] increasingSubsequence = new int[nums.length];
        int increasingSubsequenceLength = 0;
        for (int num : nums) {
            // Arrays.binarySearch(int[] arr, startIndex, endIndex, element), returns actual index or -1 - insertion index
            int insertIndex = Arrays.binarySearch(increasingSubsequence, 0, increasingSubsequenceLength, num);
            if (insertIndex < 0) {
                insertIndex = -(insertIndex + 1);
            }
            increasingSubsequence[insertIndex] = num;
            if (insertIndex == increasingSubsequenceLength) {
                increasingSubsequenceLength++;
            }
        }
        return increasingSubsequenceLength;
    }
}

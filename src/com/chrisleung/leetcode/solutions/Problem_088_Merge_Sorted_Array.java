package com.chrisleung.leetcode.solutions;

public class Problem_088_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = m-1;
        int nIndex = n-1;
        int copyIndex = nums1.length-1;
        while(nIndex >= 0) {
            if(mIndex < 0 || nums1[mIndex] < nums2[nIndex]) {
                nums1[copyIndex--] = nums2[nIndex--];
            } else {
                nums1[copyIndex--] = nums1[mIndex--];
            }
        }
    }
}

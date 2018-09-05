package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

/*
 * Faster runtime -- each call to permute is now O(n) rather than O(n^2)
 */
public class Problem_046_Permutations_v2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void permute(int[] nums, int startIndex, List<Integer> permutation, List<List<Integer>> result) {
        if(startIndex == nums.length) {
            result.add(new ArrayList<Integer>(permutation));
            return;
        }
        for(int i=startIndex; i<nums.length; i++) {
            int val = nums[i];
            permutation.add(val);
            swap(nums,startIndex,i);
            permute(nums,startIndex+1,permutation,result);
            swap(nums,startIndex,i);
            permutation.remove(permutation.size()-1);
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

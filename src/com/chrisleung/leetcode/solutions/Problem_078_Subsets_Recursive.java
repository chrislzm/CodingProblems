package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem_078_Subsets_Recursive {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        subsetsHelper(new ArrayList<Integer>(),output,0,nums);
        return output;
    }
    
    private void subsetsHelper(List<Integer> current, List<List<Integer>> allSubsets, int index, int[] arr) {
        allSubsets.add(new ArrayList<Integer>(current));
        for(int i=index; i<arr.length; i++) {
            current.add(arr[i]);
            subsetsHelper(current,allSubsets,i+1,arr);
            current.remove(current.size()-1);
        }
    }
}

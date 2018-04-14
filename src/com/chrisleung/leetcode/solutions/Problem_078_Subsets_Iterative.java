package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem_078_Subsets_Iterative {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        output.add(new ArrayList<Integer>());
        for(int n: nums) {
            List<List<Integer>> moreSubSets = new ArrayList<List<Integer>>();
            for(List<Integer> list : output) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(n);
                moreSubSets.add(newList);
            }
            output.addAll(moreSubSets);
        }
        return output;
    }
}

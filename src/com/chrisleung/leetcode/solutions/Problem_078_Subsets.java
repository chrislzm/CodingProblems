package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem_078_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
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

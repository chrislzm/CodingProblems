package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem_046_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        List<Integer> elements = new LinkedList<>();
        for(int n : nums) {
            elements.add(n);
        }
        permute(elements, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void permute(List<Integer> elements, List<Integer> permutation, List<List<Integer>> result) {
        if(elements.isEmpty()) {
            result.add(new ArrayList<Integer>(permutation));
            return;
        }
        for(int i=0; i<elements.size(); i++) {
            int val = elements.remove(i);
            permutation.add(val);
            permute(elements,permutation,result);
            permutation.remove(permutation.size()-1);
            elements.add(i,val);
        }
    }
}

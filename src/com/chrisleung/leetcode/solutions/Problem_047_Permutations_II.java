package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_047_Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return results;
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        permuteUniqueHelper(map, nums.length, new Integer[nums.length], 0, results);
        return results;
    }
    
    private void permuteUniqueHelper(Map<Integer,Integer> m, int l, Integer[] p, int i, List<List<Integer>> r) {
        if(i == l) {
            r.add(Arrays.asList(Arrays.copyOf(p,l)));
            return;
        }
        for(int key : m.keySet()) {
            if(m.get(key) > 0) {
                m.put(key,m.get(key)-1);
                p[i] = key;
                permuteUniqueHelper(m,l,p,i+1,r);
                m.put(key,m.get(key)+1);
            }
        }
    }
}

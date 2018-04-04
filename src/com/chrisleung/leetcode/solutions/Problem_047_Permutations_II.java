package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
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
        List<Integer> permutation = new ArrayList<Integer>();
        permuteUniqueHelper(map, nums.length, permutation, results);
        return results;
    }

    private void permuteUniqueHelper(Map<Integer,Integer> m, int l, List<Integer> p, List<List<Integer>> r) {
        if(l == 0) {
            r.add(new ArrayList<>(p));
            return;
        }
        for(int key : m.keySet()) {
            if(m.get(key) > 0) {
                m.put(key,m.get(key)-1);
                p.add(key);
                permuteUniqueHelper(m,l-1,p,r);
                p.remove(p.size()-1);
                m.put(key,m.get(key)+1);
            }
        }
    }
}

package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem_077_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if(k <= 0 || n <= 0) return new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combineHelper(k, 1, n, current, result);
        return result;
    }
    
    private void combineHelper(int k, int start, int end, ArrayList<Integer> current, List<List<Integer>> result) {
        if(k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i=start; i <= end-(k-1); i++) {
            current.add(i);
            combineHelper(k-1,i+1,end,current,result);
            current.remove(current.size()-1);
        }
    }
}

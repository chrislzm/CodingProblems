package com.chrisleung.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class Problem_128_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>();
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int maxRange = 1;
        for(int n : nums) {
            if(!m.containsKey(n)) {
                m.put(n,n);
                if(m.containsKey(n-1)) {
                    maxRange = Math.max(maxRange,updateRange(m,n-1,n));
                }
                if(m.containsKey(n+1)) {
                    maxRange = Math.max(maxRange,updateRange(m,n+1,n));
                }
            }
        }
        return maxRange;
    }
    
    private int updateRange(Map<Integer,Integer> m, int key1, int key2) {
        int val1 = m.get(key1);
        int min1 = key1 > val1 ? val1 : key1;
        int max1 = key1 > val1 ? key1 : val1;
        int val2 = m.get(key2);
        int min2 = key2 > val2 ? val2 : key2;
        int max2 = key2 > val2 ? key2 : val2;
        int min = min1 > min2 ? min2 : min1;
        int max = max1 > max2 ? max1 : max2;
        m.put(min,max);
        m.put(max,min);
        return max-min+1;
    }
}

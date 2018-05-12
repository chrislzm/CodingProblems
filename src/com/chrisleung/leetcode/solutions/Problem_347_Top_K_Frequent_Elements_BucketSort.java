package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_347_Top_K_Frequent_Elements_BucketSort {
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int element : nums) {
            m.put(element,m.getOrDefault(element,0)+1);
        }
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new List[nums.length+1];
        for(int element : m.keySet()) {
            int freq = m.get(element);
            if(buckets[freq] == null) {
                buckets[freq] = new ArrayList<Integer>();
            }
            buckets[freq].add(element);
        }
        List<Integer> output = new ArrayList<>();
        for(int i=nums.length; i >= 0 && output.size() < k; i--) {
            if(buckets[i] != null) {
                for(int j=0; j<buckets[i].size() && output.size() < k; j++) {
                    output.add(buckets[i].get(j));
                }
            }
        }
        return output;
    }
    
}

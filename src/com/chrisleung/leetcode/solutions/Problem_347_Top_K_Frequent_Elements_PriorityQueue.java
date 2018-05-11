package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem_347_Top_K_Frequent_Elements_PriorityQueue {
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int n : nums) {
            m.put(n,m.getOrDefault(n,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->m.get(b)-m.get(a));
        pq.addAll(m.keySet());
        List<Integer> output = new ArrayList<>();
        for(int i=0; i<k; i++) {
            output.add(pq.remove());
        }
        return output;
    }
    
}

package com.chrisleung.leetcode.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Problem_768_Max_Chunks_To_Make_Sorted_II_v2 {
    public int maxChunksToSorted(int[] arr) {
        Map<Integer,LinkedList<Integer>> m = new HashMap<>();
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        for(int i=0; i<sorted.length; i++) {
            LinkedList<Integer> l;
            if(m.containsKey(sorted[i])) {
                l=m.get(sorted[i]);
            } else {
                l=new LinkedList<>();
                m.put(sorted[i], l);
            }
            l.add(i);
        }
        int max = 0, chunks = 0;
        for(int i=0; i<arr.length; i++) {
            LinkedList<Integer> l = m.get(arr[i]);
            max = Math.max(max, l.removeFirst());
            if(max==i) chunks++;
        }
        return chunks;
    }
}

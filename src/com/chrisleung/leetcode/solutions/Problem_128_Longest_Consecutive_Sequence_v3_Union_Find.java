package com.chrisleung.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

/* Weighted quick-union with path compression */

class UnionFind {
    private int[] set;
    private int[] size;

    UnionFind(int n) {
        set = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++) {
            set[i] = i;
            size[i] = 1;
        }
    }

    void union(int n1, int n2) {
        int set1 = find(n1);
        int set2 = find(n2);
        if(set1 == set2) return;
        int smallerSet = size[set1] > size[set2] ? set2 : set1;
        int largerSet = size[set1] > size[set2] ? set1 : set2;
        size[largerSet] += size[smallerSet];
        set[smallerSet] = largerSet;
    }

    int find(int n) {
        while(n != set[n]) {
            set[n] = set[set[n]]; // Path compression
            n = set[n];
        }
        return n;
    }

    int getMaxSize() {
        int max = 0;
        for(int i=0; i<size.length; i++) {
            max = Math.max(size[i], max);
        }
        return max;
    }
}

public class Problem_128_Longest_Consecutive_Sequence_v3_Union_Find {

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        // Use map to deal with negative numbers, since our
        // UnionFind class only works with set numbering 0 to n-1
        Map<Integer,Integer> setMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            setMap.put(nums[i],i);
        }
        UnionFind uf = new UnionFind(nums.length);
        for(int n : nums) {
            if(setMap.containsKey(n+1)) {
                uf.union(setMap.get(n), setMap.get(n+1));
            }
        }
        return uf.getMaxSize();
    }
}

package com.chrisleung.leetcode.solutions;

public class Problem_261_Graph_Valid_Tree {
    
    public boolean validTree(int n, int[][] edges) {
        if(n == 1 && (edges == null || edges.length == 0)) return true;
        if(n-1 != edges.length) return false;
        int[] sets = new int[n];
        for(int i=0; i<n; i++) {
            sets[i] = i; // Put each node in its own set
        }
        for(int[] edge : edges) {
            int leftSet = getSet(edge[0],sets);
            int rightSet = getSet(edge[1],sets);
            if(leftSet==rightSet) return false; // Cycle
            sets[rightSet] = leftSet; // Merge sets
        }
        return true;
    }
    
    private int getSet(int n, int[] sets) {
        while(sets[n] != n) {
            n = sets[n];
        }
        return n;
    }
}

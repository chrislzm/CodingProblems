package com.chrisleung.leetcode.solutions;

public class Problem_323_Number_of_Connected_Components_in_an_Undirected_Graph {
    public int countComponents(int n, int[][] edges) {
        if(n == 0) return 0;
        if(edges == null || edges.length == 0) return n;
        int[] sets = new int[n];
        for(int i=0; i<n; i++) {
            sets[i] = i;
        }
        for(int[] edge : edges) {
            int leftSet = getSet(edge[0],sets);
            int rightSet = getSet(edge[1],sets);
            if(leftSet != rightSet) {
                n--;
                sets[rightSet] = leftSet;
            }
        }
        return n;
    }
       
    private int getSet(int n, int[] sets) {
        while(sets[n] != n) {
            n = sets[n];
        }
        return n;
    }
}

package com.chrisleung.leetcode.solutions;

public class Problem_821_Shortest_Distance_to_a_Character {
    public int[] shortestToChar(String S, char C) {
        int len = S.length();
        int[] output = new int[len];
        int dist = Integer.MAX_VALUE;
        for(int i=len-1; i>=0; i--) {
            if(S.charAt(i) == C) {
                dist = 0;
            } else if(dist != Integer.MAX_VALUE) {
                dist++;
            }
            output[i] = dist;
        }
        dist = Integer.MAX_VALUE;
        for(int i=0; i<len; i++) {
            if(S.charAt(i) == C) {
                dist = 0;
            } else if(dist != Integer.MAX_VALUE) {
                dist++;
            }
            output[i] = Math.min(dist,output[i]);
        }
        return output;
    }
}

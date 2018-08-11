package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_821_Shortest_Distance_to_a_Character_Old {
    public int[] shortestToChar(String S, char C) {
        int[] shortest = new int[S.length()];
        char[] str = S.toCharArray();
        List<Integer> es = new ArrayList<>();
        for(int i=0; i<str.length; i++) {
            if(str[i] == C) {
                es.add(i);
            }
        }
        int prev = Integer.MIN_VALUE;
        int next = 0;
        for(int i=0; i<es.size(); i++) {
            next = es.get(i);
            for(int j=prev>=0 ? prev+1 : 0; j<next; j++) {
                int distToPrev = j-prev;
                distToPrev = distToPrev >= 0 ? distToPrev : Integer.MAX_VALUE;
                int distToNext = next - j;
                shortest[j] = Math.min(distToPrev,distToNext);
            }
            prev = next;
        }
        if(next < str.length-1) {
            for(int i=next+1; i<str.length; i++) {
                shortest[i] = i-next;
            }
        }
        return shortest;
    }
    
    public static void main(String[] args) {
        Problem_821_Shortest_Distance_to_a_Character_Old p = new Problem_821_Shortest_Distance_to_a_Character_Old();
        String s = "aaba";
        char c = 'b';
        System.out.println(Arrays.toString(p.shortestToChar(s, c)));
    }

}

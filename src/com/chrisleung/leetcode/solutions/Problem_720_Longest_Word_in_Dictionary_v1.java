package com.chrisleung.leetcode.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem_720_Longest_Word_in_Dictionary_v1 {
    public String longestWord(String[] words) {
        Arrays.sort(words,(a,b)->a.length()==b.length() ? a.compareTo(b) : a.length()-b.length());
        Set<String> prev = new HashSet<>();
        Queue<String> q = new LinkedList<>(Arrays.asList(words));
        int curLength = 1;
        String longest = "";
        prev.add(longest);
        while(!q.isEmpty()) {
            String s = q.poll();
            if(s.length() > curLength) {
                if(s.length() == curLength+1) {
                    curLength++;
                } else {
                    break;
                }
            }
            if(prev.contains(s.substring(0,curLength-1))) {
                prev.add(s);
                if(s.length() > longest.length()) {
                    longest = s;
                }
            }
        }
        return longest;
    }
}
